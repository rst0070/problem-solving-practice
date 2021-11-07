import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/3584
public class Main
{
    static int N;
    static LinkedList<Integer>[] graph;
    static int[] depth;
    static int[] parent;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		while(testCase-- > 0){
		    N = Integer.parseInt(br.readLine());
		    graph = new LinkedList[N+1];
		    depth = new int[N+1];
		    parent = new int[N+1];
		    for(int i = 1; i <= N; i++) graph[i] = new LinkedList<Integer>();
		    
		    int a, b;
		    for(int i = 1; i < N; i++){
		        st = new StringTokenizer(br.readLine());
		        a = Integer.parseInt(st.nextToken());
		        b = Integer.parseInt(st.nextToken());
		        parent[b] = a;
		        graph[a].add(b);
		        graph[b].add(a);
		    }
		    for(int i = 1; i <= N; i++)
		        if(parent[i] == 0){
		            writeDepth(i, 1);
		            break;
		        }
		    
		    st = new StringTokenizer(br.readLine());
		    a = Integer.parseInt(st.nextToken());
		    b = Integer.parseInt(st.nextToken());
		    bw.write(lca(a, b) + "\n");
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
	        if(depth[n] == 0){
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


