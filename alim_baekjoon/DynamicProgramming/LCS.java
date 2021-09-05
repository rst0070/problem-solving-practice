import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class LCS
{
  /**
  9251번 LCS
  메모이제이션을 두 수열의 부분수열에대한 LCS를 저장하는방식으로 사용
  좀더 최적화해야함.
  */
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] strA = br.readLine().toCharArray();
        char[] strB = br.readLine().toCharArray();
        
        int N = strA.length;
        int M = strB.length;
        
        int[][] memo = new int[N][M];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++) memo[i][j] = -1;
        System.out.println(find(memo, 0, 0, strA, strB));
        
	}
	
	static int find(int[][] memo, int n, int m, char[] strA, char[] strB){
	    if(n >= strA.length || m >= strB.length) return 0;
	    if(memo[n][m] != -1) return memo[n][m];
	    
	    int max = 0;
	    int a = 0, b = 0;
	    for(int i = m; i < strB.length; i++){
	        a = find(memo, n+1, i, strA, strB);
	        b = 0;
	        if(strB[i] == strA[n])
	            b = find(memo, n+1, i+1, strA, strB) + 1;
	        max = max > a ? max : a;
	        max = max > b ? max : b;
	    }
	    memo[n][m] = max;
	    return max;
	}
	
}
