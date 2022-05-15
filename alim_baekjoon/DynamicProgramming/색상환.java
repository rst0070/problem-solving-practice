import java.io.*;
import java.util.*;

public class 색상환 {
    //https://www.acmicpc.net/problem/2482
    static long[][][][] dp = new long[1001][1001][2][2];//dp[K][N][c][c2] : N번째 수까지 K개를 뽑는데 c - N을 사용하면1 사용안하면 0, c2 - 1을 사용했으면 1 안했으면 0;
    static int N;
    static int K;
    static final long mod = 1000000003L;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        dp[0][1][0][0] = 1;
        dp[1][1][1][1] = 1;
        for(int n = 2; n <= N; n++){
            for(int k = 0; k <= n && k <= K; k++){
                dp[k][n][0][0] = (dp[k][n - 1][0][0] + dp[k][n - 1][1][0]) % mod;
                dp[k][n][0][1] = (dp[k][n - 1][0][1] + dp[k][n - 1][1][1]) % mod;

                if(k > 0){
                    dp[k][n][1][0] = dp[k - 1][n - 1][0][0];
                    dp[k][n][1][1] = dp[k - 1][n - 1][0][1];
                }
            }
        }
        long result = (dp[K][N][0][0] + dp[K][N][0][1] + dp[K][N][1][0]) % mod;
        System.out.println(result);
    }
}
