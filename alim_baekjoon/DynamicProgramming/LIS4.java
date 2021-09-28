import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class LIS4
{
  /**
   * 가장 긴 증가하는 부분수열4
   * nlogn방식도 공부하기
   */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++){
		    seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int length = LIS(0);
		memo[0] = memo[0] - 1;
		String str = memo[0]+"\n";
		
		bw.write(str, 0, str.length());
		
		for(int i = next[0]; i <= N;){
		    if(i == 0) break;
		    str = seq[i]+" ";
		    
		    bw.write(str, 0, str.length());
		    i = next[i];
		}
		
		br.close();
		bw.flush();
	}
  /**
   * memo[i]에는 i에서 시작하는 LIS의 길이저장
   * next[i]에는 i에서 lis가 시작될때 i 다음에 올 원소의 번호
   */
	static int N;
	static int[] seq = new int[1001];
	static int[] memo = new int[1001];
	static int[] next = new int[1001];
	static int LIS(int p){
	    if(p > N) return 0;
	    if(memo[p] != 0) return memo[p];
	    
	    int tmp, max = 0;
	    for(int i = p+1; i <= N; i++){
	        
	        if(seq[i] <= seq[p]) continue;
	        
	        tmp = LIS(i);
	        if( tmp > max ){
	            max = tmp;
	            next[p] = i;
	        }
	    }
	    memo[p] = max+1;
	    return memo[p];
	}
}
