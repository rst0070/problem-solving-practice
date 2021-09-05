import java.util.HashMap;
import java.util.Scanner;

public class 피보나치_수_6
{
    /**
     * 11444번 피보나치수 6
     * 1.피보나치공식이용(분할정복방식으로)
     * 2.Map을 이용한 메모이제이션!
     * 
     */
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		System.out.println(solve(n));
	}
	static HashMap<Long, Long> map = new HashMap<Long, Long>();
	
	static long solve(long n){
	    if(n == 0) return 0;
	    if(n == 1) return 1;
	    if(n == 2) return 1;
	    if(n == 3) return 2;
	    if(map.containsKey(n)) return map.get(n);
	    
	    long result = 0;
	    if(n % 2 == 1){
	        result += (solve((n-1)/2) * solve((n-1)/2)) % 1000000007;
	        result += (solve((n+1)/2) * solve((n+1)/2)) % 1000000007;

	    }else{
	        result += (solve((n/2) - 1) * solve(n/2)) % 1000000007;
	        result += (solve((n/2) + 1) * solve(n/2)) % 1000000007;
	    }
	    result = result % 1000000007;
	    map.put(n, result);
	    return result;
	}
}
