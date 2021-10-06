import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/15681
public class Main
{
  /**
   * 위 문제에서 트리의 중요한 특성을 알 수 있다. 한번씩 확인해보기!
   * 동적계획법방식 이용함
   */
    static LinkedList<Integer>[] graph;
    static int[] memo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
        StringTokenizer st = new StringTokenizer( br.readLine() );
		int N = Integer.parseInt( st.nextToken() );
		int R = Integer.parseInt( st.nextToken() );
		int Q = Integer.parseInt( st.nextToken() );
		
		graph = new LinkedList[N+1];
		memo = new int[N+1];
		for(int i = 1; i <= N; i++) graph[i] = new LinkedList<Integer>();
		
		int u, v;
		for(int i = 1; i < N; i++){
		    st = new StringTokenizer( br.readLine() );
		    u = Integer.parseInt( st.nextToken() );
		    v = Integer.parseInt( st.nextToken() );
		    graph[u].add(v);
		    graph[v].add(u);
		}
		
		//부모->자식 방향만 남도록 조정.
		removeCon(R, 0);
		
		for(int i = 0; i < Q; i++){
		    String result = countNodes( Integer.parseInt(br.readLine()) ) + "\n";
		    bw.write(result, 0, result.length());
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
  //root를 루트로 하는 서브트리의 노드개수 
    static int countNodes(int root){
        if(memo[root]!=0) return memo[root];
        
        int result = 1;
        Iterator<Integer> it = graph[root].iterator();
        
        while(it.hasNext()){
            int node = it.next();
            result += countNodes( node );
        }
        
        return memo[root] = result;
    }
    
  //재귀적으로 자식->부모 방향 그래프제거하기
    static void removeCon(int root, int parent){
        Iterator<Integer> it = graph[root].iterator();
        while(it.hasNext()){
            int node = it.next();
            if(node == parent) it.remove();
            else removeCon(node, root);
        }
    }
}
