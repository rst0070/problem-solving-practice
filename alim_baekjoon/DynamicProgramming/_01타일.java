import java.util.Scanner;

public class _01타일 {
    public static void main(String[] args)throws Exception{
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();    s.close();
        memo = new int[N+1];
        memo[0] = 1; 
        memo[1] = 1;
        for(int i = 2; i <= N; i++){
            memo[i] = memo[i - 1] + memo[i - 2];
            memo[i] %= 15746;
        }

        System.out.println(memo[N]);
    } 
    
    static int[] memo;

}
