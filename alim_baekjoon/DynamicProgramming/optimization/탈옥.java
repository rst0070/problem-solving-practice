import java.io.*;
import java.util.*;

public class 탈옥 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());//방개수
        G = Integer.parseInt(st.nextToken());//간수 명수
        sumCost = new long[L+1];
        dp = new long[G+1][L+1];//[i][j]: i명의 간수가 j번째 죄수까지 관리할때 최소비용

        st = new StringTokenizer(br.readLine());
        sumCost[1] = Long.parseLong(st.nextToken());
        for(int i = 2; i <= L; i++) sumCost[i] = Long.parseLong(st.nextToken()) + sumCost[i-1];

        for(int l = 1; l <= L; l++)
            dp[1][l] = cost(1, l);

        for(int g = 2; g <= G; g++)
            solve(g, 1, L, 1, L);
        System.out.println(dp[G][L]);
    }
    static int L, G;
    static long[] sumCost;
    static long[][] dp;
    static long MAX = 8000*8000*1000_000_000;

    static void solve(int g, int lLow, int lHigh, int kLow, int kHigh){
        if(lLow > lHigh || kLow > kHigh) return;
        
        int lMid = (lLow + lHigh) >> 1;
        int optK = kLow;
        //lMid에 대한 최적의k를 구하면 lMid보다 큰 l, 작은 l에대한 k의 범위가 좁혀진다.
        for(int k = kLow ; k <= Math.min(kHigh, lMid); k++){
            long num = dp[g-1][k] + cost(k+1, lMid);
            if(k == kLow || num < dp[g][lMid]){
                dp[g][lMid] = num;
                optK = k;
            }
        }
        solve(g, lLow, lMid - 1, kLow, optK);
        solve(g, lMid + 1, lHigh, optK, kHigh);
    }

    static long cost(int start, int end){ return (end - start + 1)*(sumCost[end] - sumCost[start - 1]);}
}
