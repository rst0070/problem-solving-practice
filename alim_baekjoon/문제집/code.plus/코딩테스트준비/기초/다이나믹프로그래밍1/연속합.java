import java.io.*;
import java.util.*;

public class 연속합 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)  seq[i] = Integer.parseInt(st.nextToken());

        int result = MIN;
        for(int i = 0; i < N; i++) result = Math.max(solve(i), result);

        System.out.println(result);
    }

    static final int MIN = -1000 * 100000;
    static int N;
    static int[] seq = new int[100000];
    static int[] dp = new int[100000];
    static{
        for(int i = 0; i < 100000; i++)    dp[i] = MIN - 1;
    }

    static int solve(int n){
        if(n >= N) return 0;
        if(dp[n] >= MIN) return dp[n];

        dp[n] = seq[n] + solve(n+1);
        dp[n] = Math.max(dp[n], seq[n]);

        return dp[n];
    }
}
