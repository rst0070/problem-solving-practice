import java.util.*;
//https://www.acmicpc.net/problem/1240
//트리라는 조건이 있기에 visited를 dfs하면서 지울수 있다고 판단함(사이클이 없기에)
public class Main
{
    static class Pair {
        int node, weight;
        public Pair(int node, int weight){ this.node = node; this.weight = weight;}
        @Override
        public boolean equals(Object obj){
            if((Integer)obj == this.node) return true;
            return false;
        }
    }
    
    static LinkedList<Pair>[] graph;
    static boolean[] visited;
    static int N;
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner( System.in );

		N = s.nextInt();
		int M = s.nextInt();
		
		graph = new LinkedList[N+1];
		visited = new boolean[N+1];
		
		int a, b, l;
		for(int i = 1; i < N; i++){
		    a = s.nextInt();
		    b = s.nextInt();
		    l = s.nextInt();
		    
		    if(graph[a] == null) graph[a] = new LinkedList<Pair>();
		    if(graph[b] == null) graph[b] = new LinkedList<Pair>();
		    Pair toB = new Pair(b, l);
		    Pair toA = new Pair(a, l);
		    graph[a].add(toB);
		    graph[b].add(toA);
		}
		
		for(int i = 0; i < M; i++){
		    a = s.nextInt();
		    b = s.nextInt();
		    System.out.println( dfs(a, b) );
		}
        s.close();
	}
	
	//a노드에서 b를 찾아라.
	static int dfs(int a, int b){
	    visited[a] = true;
	    
	    int result = -1;
	    Iterator<Pair> list = graph[a].iterator();
	    while(list.hasNext()){
	        Pair p = list.next();
	        if(visited[p.node]) continue;
	        if(p.node == b){
	            result = p.weight;
	            break;
	        }
	        int tmp = dfs(p.node, b);
	        if(tmp != -1){
	            result = tmp + p.weight;
	            break;
	        }
	    }
	    visited[a] = false;
	    return result;
	}

	
}
