import java.util.*;
public class 계단_수 {

    static int[][][] dp = new int[1050][100][10];
    static int N;
    static{
        for(int i = 0; i < 1050; i++)
            for(int n = 0; n < 100; n++)
                for(int num = 0; num < 10; num++)
                    dp[i][n][num] = -1;
        
    }
    //https://www.acmicpc.net/problem/1562
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        int result = 0;
        for(int num = 1; num < 10; num++){
            result += solve(0, N-1, num);
            result %= 1000000000;
        }
        System.out.println(result);
    }

    static int solve(int vis, int n, int num){
        if(num < 0 || num > 9) return 0;

        vis = vis | (1 << num);
        if(dp[vis][n][num] != -1) return dp[vis][n][num];
        if(n == 0){
            int result = 1;
            if(vis < 1023) result = 0;
            return result;
        }

        dp[vis][n][num] = (solve(vis, n-1, num + 1) + solve(vis, n-1, num - 1))%1000000000;
        return dp[vis][n][num];
    }
}
