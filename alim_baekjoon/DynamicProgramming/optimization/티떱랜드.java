import java.io.*;
import java.util.*;
public class 티떱랜드 {
    static int N, K;
    static long[][] awk = new long[4001][4001];//awk[i][j] = awk[j][i] : i와 j가 함께 있을때 각각이 느끼는 어색함
    static long[][] awkSum = new long[4001][4001];//awkSum[i][j] = i가 1부터 j까지와 느끼는 어색함의 합
    static long[][] cost = new long[4001][4001];//cost[i][j] : i번째 부터 j번째까지 함께있을때 발생되는 어색함의 총 합
    static long[][] dp = new long[4001][4001];//
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                awk[i][j] = Long.parseLong(st.nextToken());
                awkSum[i][j] = awkSum[i][j-1] + awk[i][j];
            }       
        }

        fillCost();
        for(int i = 1; i <= N; i++) dp[1][i] = cost[1][i];
        for(int k = 2; k <= K; k++) dncOpt(k, k, N, k - 1, N);
        System.out.println(dp[K][N]);
    }

    static void fillCost(){
        for(int i = 1; i <= N; i++){
            cost[i][i] = 0;
            for(int j = i+1; j <= N; j++){
                cost[i][j] = cost[i][j-1] + awkSum[j][j] - awkSum[j][i-1];
            }
                
        }
    }

    static void dncOpt(int lev, int nLeft, int nRight, int optLeft, int optRight){
        if(nLeft > nRight) return;
        int mid = (nLeft + nRight) >> 1;
        int opt = -1;
        for(int o = optLeft; o <= Math.min(mid - 1, optRight); o++){
            long val = dp[lev-1][o] + cost[o + 1][mid];
            if(opt == -1 || val < dp[lev][mid]){
                opt = o;
                dp[lev][mid] = val;
            }
        }
        dncOpt(lev, nLeft, mid - 1, optLeft, opt);
        dncOpt(lev, mid + 1, nRight, opt, optRight);
    }
}
