import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            String answer = "YES\n";

            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            board = new char[H][];
            vis = new boolean[H][W];

            for(int h = 0; h < H; h++)
                board[h] =br.readLine().toCharArray();
            
               
            for(int h = 0; h < H; h++)
                for(int w = 0; w < W; w++){
                    if(!vis[h][w] && board[h][w] == '1'){
                        int result = find(h, w);
                        if(result == -1) answer = "NO\n";
                        minH = -1; minW = -1; maxH = -1; maxW = -1;
                    }
                }
            bw.write(answer);
        }
        bw.flush();
    }
    static int H, W;
    static char[][] board;
    static boolean[][] vis;
    static int minH = -1, minW = -1, maxH = -1, maxW = -1;
    
    static int find(int h, int w){
        if(h < 0 || h >= H || w < 0 || w >= W || board[h][w] == '0') return 0;
        if(vis[h][w]) return 1;

        vis[h][w] = true;
        
        int up = find(h - 1, w);
        if(up == 0){
            if(minH == -1) minH = h;
            else if(minH != h) return -1;
        }
        int down = find(h + 1, w);
        if(down == 0){
            if(maxH == -1) maxH = h;
            else if(maxH != h) return -1;
        }

        int left = find(h, w - 1);
        if(left == 0){
            if(minW == -1) minW = w;
            else if(minW != w) return -1;
        }

        int right = find(h, w + 1);
        if(right == 0){
            if(maxW == -1) maxW = w;
            else if(maxW != w) return -1;
        }

        //직사각형이 아님
        if(up == -1 || down == -1 || left == -1 || right == -1) return -1;
        return 1;
    }
}
