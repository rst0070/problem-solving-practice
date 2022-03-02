import java.io.*;

public class 오르막수 {

    //https://www.acmicpc.net/problem/11057
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(dp(N, 0));
    }   
    
    static int[][] memo = new int[1001][10];
    static{
        for(int i = 0; i < 1001; i++)
            for(int j = 0; j < 10; j++) memo[i][j] = -1;
    }
    static int dp(int n, int prev){
        if(n == 1) return 10 - prev;
        if(memo[n][prev] != -1) return memo[n][prev];

        memo[n][prev] = 0;
        for(int i = prev; i < 10; i++){memo[n][prev] += dp(n - 1, i); memo[n][prev] %= 10007;}
        return memo[n][prev];
    }
}
