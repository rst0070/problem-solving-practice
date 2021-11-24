import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1520
class Main{

    static int[][] map;
    static int[][] dp;
    static int M, N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[M][N];
        map = new int[M][N];

        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)  dp[i][j] = -1;

        for(int h = 0; h < M; h++){
            st = new StringTokenizer(br.readLine());
            for(int w = 0; w < N; w++)
                map[h][w] = Integer.parseInt(st.nextToken());
        }
        br.close();
        dp[M-1][N-1] = 1;

        System.out.println(find(0, 0));
    }

    static int[][] delta = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    static int find(int x, int y){
        if(dp[y][x] != -1) return dp[y][x];

        int result = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(map[y][x] <= map[ny][nx]) continue;
            result += find( nx, ny);
        }
        return dp[y][x] = result;
    }


}
