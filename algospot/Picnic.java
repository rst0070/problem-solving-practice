import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Picnic
{
  /**
   * 완전 탐색을 이용하는 문제.
   * 친구 한쌍을 만들어내고 나머지 남은 인원들로 부분문제를 만들어 재귀호출로 해결한다.
   * 어려웠던 부분은 기저사례를 어떻게 생각하고 구현할 것 인가..
   *
   * 기저사례는 모두다 매칭이 된 상태. 즉 1을 반환하는 상태 뿐이다.
   * 답이 만들어지지 않는 기저사례는 생각해내기 힘든데,
   * 이는 매칭을 시켜보는과정에서 자연스럽게 알 수 있으므로(coutn == 0 상태)
   * 자연스럽게 0이 반환되도록 놔두면 된다.
   */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		while(testCase-- > 0){
		    st = new StringTokenizer(br.readLine());
		    int n = Integer.parseInt(st.nextToken());
		    int m = Integer.parseInt(st.nextToken());
		    boolean[][] relation = new boolean[n][n];
		    st = new StringTokenizer(br.readLine());
		    for(int i=0; i < m; i++){
		        int a = Integer.parseInt(st.nextToken());
		        int b = Integer.parseInt(st.nextToken());
		        relation[a][b] = true;
		        relation[b][a] = true;
		    }
		    //친구 관계확인하는 relation 배열 완성.
		    System.out.println(solve(relation, new boolean[n]));
		}
		br.close();
	}
	
	/**
	 * start: 짝을 매칭해야할 첫번째 사람
	 * matched[i]: i번째 사람이 짝이 있으면 true, 없으면 false
	 */
	static int solve(boolean[][] relation, boolean[] matched){
	    int notMatched = -1;
	    for(int i = 0; i < matched.length; i++){
	        if(!matched[i]){ notMatched = i; break;}
	    }
	    // 모두 매칭됐다면 답이 하나 완성된것.(기저사례)
	    if(notMatched == -1) return 1;
	    
	    int count = 0;
	    for(int i = notMatched+1; i < matched.length; i++){
	        if(!matched[i]){
	            if(relation[notMatched][i]){
	                boolean[] newMatched = matched.clone();
	                newMatched[notMatched] = true;
	                newMatched[i] = true;
	                count += solve(relation, newMatched);
	            }
	        }
	    }
	    return count;
	}
}
