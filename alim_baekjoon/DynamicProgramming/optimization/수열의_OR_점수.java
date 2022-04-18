import java.io.*;
import java.util.*;

public class 수열의_OR_점수 {
    static int N, K;
    static long[] seq = new long[5001];
    static long[] sum = new long[5001];
    static long[][] dp = new long[5001][5001];//dp[k][n] : n번째 까지 k개의 그룹으로 나눴을때 점수의 최댓값
    static long[][] cost = new long[5001][5001];//cost[i][j] : i번째 부터 j번째 까지 그룹으로 묶었을때 or점수
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            seq[i] = Long.parseLong(st.nextToken());
        
        fillCost();
        for(int i = 1; i <= N; i++)
            dp[1][i] = cost[1][i];
        
        for(int k = 2; k <= N; k++)
            dncOpt(k, k, N, k - 1, N);
        System.out.println(dp[K][N]);
    }

    static void fillCost(){
        for(int i = 1; i <= N; i++){
            cost[i][i] = seq[i];
            for(int j = i + 1; j <= N; j++) cost[i][j] = cost[i][j - 1] | seq[j];
        }
    }

    static void dncOpt(int lev, int nLeft, int nRight, int optLeft, int optRight){
        if(nLeft > nRight) return;
        int mid = (nLeft + nRight) >> 1;
        int opt = -1;
        for(int o = optLeft; o <= Math.min(optRight, mid - 1); o++){
            long val = dp[lev - 1][o] + cost[o+1][mid];
            if(opt == -1 || val > dp[lev][mid]){
                opt = o;
                dp[lev][mid] = val;
            }
        }
        dncOpt(lev, nLeft, mid - 1, optLeft, opt);
        dncOpt(lev, mid + 1, nRight, opt, optRight);
    }

}
