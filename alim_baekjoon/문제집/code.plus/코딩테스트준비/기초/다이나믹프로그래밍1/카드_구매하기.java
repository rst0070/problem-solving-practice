import java.io.*;
import java.util.*;

public class 카드_구매하기 {
    
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) P[i] = Integer.parseInt(st.nextToken());

        System.out.println(solve(N, N));
    }

    static int N;
    static int[] P = new int[1001];
    static int[][] memo = new int[1001][1001];
    static{
        for(int i = 0; i < 1001; i++)
            for(int j = 0; j < 1001; j++)   memo[i][j] = -1;
    }

    static int solve(int n, int i){
        if(n == 0) return 0;
        if(i == 0) return -1;
        if(memo[n][i] != -1) return memo[n][i];

        for(int m = 0; m*i <= n; m++){
            int multi = m * P[i];
            int next = solve(n - m*i, i-1);
            if(next != -1){
                memo[n][i] = Math.max(memo[n][i], multi + next);
            }
        }

        return memo[n][i];

    }
}
