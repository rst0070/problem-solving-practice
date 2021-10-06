import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11725
class Main
{
  /**
   * 그래프식으로 부모->자식, 자식->부모 경로를 모두 저장한 후
   * 부모노드에서 재귀적으로 자식으로 들어가서 부모->자식 경로를 제거한다.
   */
    static LinkedList<Integer>[] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		
        StringTokenizer st; int a, b;
		int N = Integer.parseInt(br.readLine());
		
		graph = new LinkedList[N+1];
		for(int i = 1; i <= N; i++) graph[i] = new LinkedList<Integer>();
		
		for(int i = 1; i < N; i++){
		    st = new StringTokenizer( br.readLine() );
		    a = Integer.parseInt( st.nextToken() );
		    b = Integer.parseInt( st.nextToken() );
		    graph[a].add(b);
		    graph[b].add(a);
		    
		}
		br.close();
		removeCon( 1, 0);
		//자식에서 부모로 가는길 1개만 남으므로 출력
		for(int i = 2; i <= N; i++){
		    String result = graph[i].peek()+"\n";
		    bw.write( result, 0, result.length() );
		}
		
		bw.flush();
		bw.close();
	}
	
    //부모노드에서 자식노드로 가는 graph를 삭제해버리기(자신의 부모노드로 가는 길은 보존)
    static void removeCon(int root, int parent){
        Iterator<Integer> it = graph[root].iterator();
        while(it.hasNext()){
            int node = it.next();
            if( node == parent ) continue;
            
            removeCon(node, root);
            it.remove();
        }
    }
}
