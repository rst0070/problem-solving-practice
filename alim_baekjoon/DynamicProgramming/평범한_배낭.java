import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한_배낭
{
    /**
     * 12865번
     * 배낭문제, 동적계획법. 
     * 1. 최적 부분구조가 성립하는가?
     * 배낭의 허용 무게를 조절하면 가능하긴하다.
     * 즉 이를 처리하는 함수의 형태가
     * maxValue(int K, int[] w, int [] v)
     * 위와같다면 가능하겠지만, 메모이제이션을 어떻게 할 것 인가..
     * 메모이제이션은 일반적으로 함수의 입력값과 동일하게 하기 때문이다.
     * 
     * maxValue(int K, int index_of_start)
     * 이렇게 변형한다면?
     * -1 < index_of_start < 100 : 이 위치부터 물건을 고려하는 작업을 시작하는것.
     * K <= 100,000 이기 때문에 메모이제이션의 크기는 최대 10,000,000 == 38mb
     * 문제의 메모리 제한이 512MB 이므로 충분히 가능할 듯.
     * 
     */
    static int[][] memo = new int[100001][100];
    static int[] weights = new int[100];
    static int[] values = new int[100];
    static int N;
    static{
        for(int i = 0; i < 100001; i++)
        for(int j = 0; j < 100; j++) memo[i][j] = -1;
    }
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++){
		    st = new StringTokenizer(br.readLine());
		    weights[i] = Integer.parseInt(st.nextToken());
		    values[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		System.out.println( maxValue(K, 0) );
	}
	
	static int maxValue(int k, int idx){
	    if(k==0) return 0;
	    if(idx >= N) return 0;
	    if( memo[k][idx] != -1 ) return memo[k][idx];
	    
	    int a = 0;
	    if(k >= weights[idx]){
	        a = maxValue(k - weights[idx], idx+1) + values[idx];
	    }
	    int b = maxValue(k, idx+1);
	    memo[k][idx] = a > b ? a : b;
	    
	    return memo[k][idx];
	}
	
	
}
