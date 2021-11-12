import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/15938
class Main{

/**
 * 완전탐색은 4^T정도 시간걸림
 * 방법은 지도의 모양대로 dp로 메모를 해놓는것.
 * 하지만 지도의 크기가 크다.
 * 
 * 하지만 T의 크기(움직일 수 있는 범위)는 작다.
 * 따라서 T를 이용해서 지도를 만드는 방법이 있지만
 * 외부적으로는 절대경로를 사용하지만
 * 내부적으로는 T를 이용해 정보를 저장하자.
 * 
 * memo와 map을 같이 사용해도 될듯.
 * memo[집][0~T] = 1;
 * memo[장애물][0~T] = 0; visited이용해서 장애물은 바로 넘어감
 * 
 * 좌표설정할때 복잡하므로 주의하기.
 */
    
    
    static class Memo{
        static int T;
        static int Xs, Ys;
        static int Xh, Yh;
        static int N;
        static int[][][] memo;
        static boolean[][][] visited;
        
        static private int moveX;
        static private int moveY;
        static void setting(int t, int xStart, int yStart, int xHome, int yHome){
            T = t;
            memo = new int[2*T + 1][2*T + 1][T+1];
            visited = new boolean[2*T + 1][2*T + 1][T+1];

            moveX = T - xStart;
            moveY = T - yStart;
            
            Xs = T;
            Ys = T;
            Xh = moveX + xHome;
            Yh = moveY + yHome; 
            
            for(int i = 0; i <= T; i++)
                if(checkLimit(xHome, yHome, i)) setVal(xHome, yHome, i, 1);
        }
        static int getVal(int x, int y, int t){
            return memo[x + moveX][y + moveY][t];
        }
        static void setVal(int x, int y, int t, int value){
            memo[x + moveX][y + moveY][t] = value;
            visited[x + moveX][y + moveY][t] = true;
        }
        static boolean isVisited(int x, int y, int t){
            return visited[x + moveX][y + moveY][t];
        }
        
        static boolean checkLimit(int x, int y, int t){
            int mx = x + moveX;
            int my = y + moveY;
            if(x < -100000 || x > 100000 || y < -100000 || y > 100000 || t < 0
            || mx < 0 || mx >= memo.length || my < 0 || my >= memo[0].length) return false;
            return true;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t, xs, ys, xh, yh;
        StringTokenizer st = new StringTokenizer(br.readLine());
        xs = Integer.parseInt(st.nextToken());
        ys = Integer.parseInt(st.nextToken());
        
        t = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        xh = Integer.parseInt(st.nextToken());
        yh = Integer.parseInt(st.nextToken());
        Memo.setting(t, xs, ys, xh, yh);
        
        Memo.N = Integer.parseInt(br.readLine());
        for(int i = 0; i < Memo.N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j = 0; j <= Memo.T; j++)
                if(Memo.checkLimit(x, y, j)) Memo.setVal( x, y, j, 0);

        }
        br.close();
        System.out.println(find(xs, ys, t));
    }
    
    static int[] dx = { -1, 1 };
    static int[] dy = { -1, 1 };
    static final int mod = 1000000007;
    static int find(int x, int y, int t){
        if(!Memo.checkLimit(x, y, t)) return 0;
        if(Memo.isVisited(x, y, t) || t == 0) return Memo.getVal(x, y, t);
        
        int result = 0;
        for(int i = 0; i < 2; i++){
            result = ( result + find(x + dx[i], y, t-1) ) % mod;
            result = ( result + find(x, y + dy[i], t-1) ) % mod;
        }
        Memo.setVal(x, y, t, result);
        return result;
    }


}
