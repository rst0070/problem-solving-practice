import java.util.*;

public class 쉬운_계단_수 {
 
    public static void main(String[] args)throws Exception{
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        long result = 0;
        for(int i = 1; i < 10; i++)
            result += solve(N, i);
        result = result % divide;
        s.close();

        System.out.println(result);
    }

    static long[][] memo = new long[101][10];
    static final long divide = 1000_000_000;
    static{
        for(int i = 0; i < 101; i++)
            for(int j = 0; j < 10; j++) memo[i][j] = -1;
    }
    static long solve(int n, int num){
        if(n == 1) return 1;
        if(memo[n][num] != -1) return memo[n][num];

        if(num == 9) memo[n][num] = solve(n - 1, num - 1);
        else if(num == 0) memo[n][num] = solve(n - 1, num + 1);
        else memo[n][num] = (solve(n - 1, num + 1) + solve(n - 1, num - 1)) % divide;

        return memo[n][num];
    }
}
