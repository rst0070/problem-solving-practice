import java.io.*;
import java.util.*;

public class RGB거리2 {
    static int N;
    static int[][] c = new int[3][1000];
    static int[] c1 = new int[1000];
    static int[] c2 = new int[1000];
    static int[][][] dp = new int[3][1000][3];
    static{
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 1000; j++)
                for(int k = 0; k < 3; k++)
                    dp[i][j][k] = -1;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            c[0][i] = Integer.parseInt(st.nextToken());
            c[1][i] = Integer.parseInt(st.nextToken());
            c[2][i] = Integer.parseInt(st.nextToken());
        }

        int result = solve(0, 0, 0);
        result = Math.min(result, solve(1, 0, 1));
        result = Math.min(result, solve(2, 0, 2));
        System.out.println(result);

    }

    static int solve(int start, int now, int color){
        if(now >= N) return 0;
        if(dp[start][now][color] != -1) return dp[start][now][color];
        if(now == N -1 && start == color) return Integer.MAX_VALUE;

        dp[start][now][color] = solve(start, now + 1, (color + 1) % 3);
        dp[start][now][color] = Math.min(dp[start][now][color], solve(start, now + 1, (color + 2) % 3));
        return dp[start][now][color] += c[color][now];
    }
}
