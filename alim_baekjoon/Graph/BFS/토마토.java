import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/7569
public class 토마토 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][N][M];
        countDown = H * M * N;

        LinkedList<Tomato> queue = new LinkedList<Tomato>();
        for(int h = 0; h < H; h++)
            for(int n = 0; n < N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++){
                    board[h][n][m] = Integer.parseInt(st.nextToken());
                    if(board[h][n][m] == 1){queue.add(new Tomato(h, n, m, 0));}
                    else if(board[h][n][m] == -1)   countDown--;
                }
            }
        
        int result = -1;
        while(!queue.isEmpty()){
            Tomato now = queue.poll();
            countDown--;
            result = now.time;
            for(int i = 0; i < dir.length; i++){
                int h = dir[i][0] + now.h;
                int n = dir[i][1] + now.n;
                int m = dir[i][2] + now.m;
                if(h < 0 || m < 0 || n < 0 ||
                    h >= H || m >= M || n >= N ||
                    board[h][n][m] != 0) continue;
                board[h][n][m] = 1;
                queue.add(new Tomato(h, n, m, result + 1));
            }
        }
        if(countDown > 0) result = -1;
        System.out.println(result);
    }

    static int H, M, N;
    static int[][][] board;
    static int countDown;
    static int[][] dir = {
        {1, 0, 0},
        {-1, 0, 0},
        {0, 1, 0},
        {0, -1, 0},
        {0, 0, 1},
        {0, 0, -1}
    };
    static class Tomato{
        int h, n, m;
        int time;
        Tomato(int h, int n, int m, int time){this.h = h; this.n = n; this.m = m; this.time = time;}
    }
}
