import java.util.Scanner;
import java.math.BigInteger;
//https://www.acmicpc.net/problem/2407
public class Main
{
    //nCr구하기
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner( System.in );
	    int n = s.nextInt();
		int r = s.nextInt();
		System.out.println( solve(n, r).toString() );
	}
	
	static BigInteger[][] memo = new BigInteger[101][101];

    static BigInteger solve(int n, int r){
        if(n < r) return new BigInteger("0");
        if(n == r) return new BigInteger("1");
        if(r == 0) return new BigInteger("1");
        
        if( memo[n][r] != null ) return memo[n][r];
        BigInteger result = new BigInteger("0");
        result = result.add( solve(n-1, r) );
        result = result.add( solve(n-1, r-1) );
        return memo[n][r] = result;
    }
}
