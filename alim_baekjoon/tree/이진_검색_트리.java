import java.io.*;
//https://www.acmicpc.net/problem/5639
class Main
{
  /**
   * 이진검색트리의 속성: 왼쪽 자식보다 자신이 크며 오른쪽 자식이 자신보다 크다.
   * 이 속성을 적용해 preorder에서 postorder로 전환
   * 적용방법은 왼쪽자식 개수 구할때 적용하면됨.(왼쪽자식의 특성)
   */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		String line;
		int[] pre = new int[10000];
		int N = 0;
		while( (line = br.readLine())!=null ){
		    pre[N] = Integer.parseInt(line);
		    N++;
		}
		br.close();
		System.out.print(post(pre, 0, N-1));
	}
	
	static String post(int[] pre, int h, int t){
	    if(h > t) return "";
	    int root = pre[h];
	    int left = 0;
	    while( (h+left+1) <= t && pre[h+left+1] < root) left++;
	    
	    String lp = post(pre, h+1, h + left);
	    String rp = post(pre, h + left + 1, t);
	    return lp + rp + root + "\n";
	}
}
