import java.io.*;
import java.util.*;

public class 열쇠9328 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            building = new char[H][];
            visit = new boolean[H][W]; for(int h = 0; h < H; h++) Arrays.fill(visit[h], false);
            key = new boolean[26]; Arrays.fill(key, false);
            toGo = new LinkedList<Point>();
            for(int i = 0; i < 26; i++) lockedDoors[i] = new LinkedList<Point>();

            //빌딩정보
            for(int h = 0; h < H; h++){
                building[h] = br.readLine().toCharArray();
                for(int w = 0; w < W; w++)
                    if(building[h][w] != '*' && (h == 0 || h == H-1 || w == 0 || w == W-1)){
                        //입구를 찾아서 큐에 추가
                        toGo.add(new Point(h, w));
                        visit[h][w] = true;
                    }
            }

            //열쇠정보 저장
            String keyInfo = br.readLine();
            if(keyInfo.charAt(0) != '0')
                for(int i = 0; i < keyInfo.length(); i++) key[keyInfo.charAt(i) - 'a'] = true;

            int result = 0;

            //탐색시작
            while(!toGo.isEmpty()){
                Point now = toGo.poll();
                char val = now.getVal();
                
                //벽이면 무시
                if(val == '*') continue;

                //못여는 문이면 못열었다고 저장
                if('A' <= val && val <= 'Z' && !key[val - 'A']){
                    lockedDoors[val - 'A'].add(now);
                    continue;
                }

                //새로운 열쇠가 열수있는 못연문들을 다음에 방문
                if('a' <= val && val <= 'z' && !key[val - 'a']){
                    key[val - 'a'] = true;
                    while(!lockedDoors[val-'a'].isEmpty()){
                        Point next = lockedDoors[val-'a'].poll();
                        toGo.add(next);
                        visit[next.h][next.w] = true;
                    }
                }

                //문서
                if(val == '$') result++;

                //다음방문지점들
                for(int i = 0; i < 4; i++){
                    Point next = new Point(now.h + dir[i][0], now.w + dir[i][1]);
                    if(next.h >= 0 && next.h < H && next.w >= 0 && next.w < W && !visit[next.h][next.w]){
                        toGo.add(next);
                        visit[next.h][next.w] = true;
                    }
                }
                    
            }

            bw.write(result + "\n");

        }
        bw.flush();
    }

    static int H, W;
    static char[][] building;
    static boolean[][] visit;
    static boolean[] key;
    static LinkedList<Point> toGo;
    static LinkedList<Point>[] lockedDoors = new LinkedList[26];
    static int[][] dir = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    static class Point{
        int h, w;
        Point(int h, int w){this.h = h; this.w = w;}
        char getVal(){return building[h][w];}
    }

}
