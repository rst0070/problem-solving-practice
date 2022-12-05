import java.io.*;
import java.util.*;

public class D {

    static int[] cost = new int[101];
    static int[] value = new int[101];
    static int[][] dp = new int[101][100001]; // 최대 과일의 수

    /**
     * N개 이상을 구하는데 최소비용
     * 비용과 과일의 수가 주어짐
     * 이때 비용을 최소화하여 
     * dp[i][j] : 1~i 쿠폰을 보고 과일이 j개 이상이어야 할때 비용의 최소값. 
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            value[i] = cost[i] + Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i <= N; i++)
            dp[0][i] = i;

        for(int i = 1; i <= M; i++)
            for(int j = 1; j <= N; j++){
                int prevJ = j - value[i];
                if(prevJ < 0) prevJ = 0;

                dp[i][j] = Math.min(dp[i-1][j], dp[i - 1][prevJ] + cost[i]);
            }

        bw.write(dp[M][N] + "\n");
        bw.flush();
    }
    
}
