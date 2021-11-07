import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11437
public class Main
{
  /**
  트리를 만들고 => graph
  루트에서 부터 내려가며 노드의 깊이를 기록하며 이를 이용해 노드의 부모를 기록한다.
  
  LCA를 구하는 방법은 두 노드가 주어졌을때 깊이를 비교하여 두 노드가 깊이가 같고 같은 노드일때까지 계속 깊이를 낮추는것.  
  */
    static int N, M;
    static LinkedList<Integer>[] graph;
    static int[] depth;
    static int[] parent;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new LinkedList[N+1];
		for(int i = 1; i <= N; i++) graph[i] = new LinkedList<Integer>();
		depth = new int[N+1];
		parent = new int[N+1];
		
		for(int i = 1; i < N; i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    graph[a].add(b);
		    graph[b].add(a);
		}
		parent[1] = 1;
		writeDepth(1, 1);
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    int node = lca(a, b);
		    bw.write(node + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void writeDepth(int now, int dep){
	    depth[now] = dep;
	    Iterator<Integer> it = graph[now].iterator();
	    while(it.hasNext()){
	        int n = it.next();
	        if(parent[n] == 0){
	            parent[n] = now;
	            writeDepth(n, dep+1);
	        }
	    }
	}
	
	static int lca(int a, int b){
	    while( a != b ){
	        if(depth[a] < depth[b]) b = parent[b];
	        else a = parent[a];
	    }
	    return a;
	}

}


