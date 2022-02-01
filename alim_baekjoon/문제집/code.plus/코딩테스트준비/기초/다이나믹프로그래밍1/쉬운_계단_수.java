import java.util.*;

public class 쉬운_계단_수 {
 
    public static void main(String[] args)throws Exception{
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        long result = 0;
        for(int i = 1; i < 10; i++)
            result += (solve(N, i) % mode);
        System.out.println(result);
    }

    static long[][] memo = new long[101][10];
    static final long mode = 1000_000_000;
    static{
        for(int i = 0; i < 101; i++)
            for(int j = 0; j < 10; j++) memo[i][j] = -1;
    }
    static long solve(int n, int num){
        if(num < 0 || num > 9) return 0;
        if(n == 1) return 1;
        if(n == 0) return 0;
        if(memo[n][num] != -1) return memo[n][num];

        return memo[n][num] = (solve(n - 1, num + 1) + solve(n - 1, num - 1)) % mode;
    }
}
