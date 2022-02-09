import java.util.*;

public class 제곱수의_합 {

    static int[] dp = new int[100001];

    static{
        for(int i = 0; i < 100001; i++) dp[i] = -1;
    }
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();

        int result = find(n);
        System.out.println(result);
    }

    static int find(int n){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];

        int result = 100000;
        for(int i = 1; i*i <= n; i++){
            int c = find(n - i*i) + 1;
            result = Math.min(result, c);
        }
        return dp[n] = result;
    }
}
