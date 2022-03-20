import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class LCS
{
  /**
  9251번 LCS
  두 문자열의 특정 위치까지의 LCS를 저장하는 배열을 만들자.
  참고: https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence
  */
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strA = br.readLine().toCharArray();
        strB = br.readLine().toCharArray();
        
        N = strA.length;
        M = strB.length;
        
        memo = new int[N][M];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++) memo[i][j] = -1;
		
        System.out.println(find(N-1, M-1));
	}
	static int N, M;
	static char[] strA, strB;
	static int[][] memo;
	static int find(int n, int m){
		if(n < 0 || m < 0) return 0;
		if(memo[n][m] != -1) return memo[n][m];

		if(strA[n] == strB[m]){
			memo[n][m] = Math.max(1 + find(n-1, m-1), find(n - 1, m));
			memo[n][m] = Math.max(memo[n][m], find(n, m - 1));
		}else{
			memo[n][m] = Math.max(find(n-1, m), find(n, m-1));
		}

		return memo[n][m];
	}
}
