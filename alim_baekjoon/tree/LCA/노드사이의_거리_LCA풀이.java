import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1240
class Main{
    
    /**
     * LCA를 이용한 방법.
     * 공통부모 찾아 올라가면서 거리 구하기 
     */
    static int N, M;
    static LinkedList<Path>[] graph;
    static int[] depth;
    static int[][] parent;
    
    static class Path{
        int dis;
        int node;
        public Path(int dis, int node){this.dis = dis; this.node = node;}
    }
    
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new LinkedList[N+1];
		for(int i = 1; i <= N; i++) graph[i] = new LinkedList<Path>();
		depth = new int[N+1];
		parent = new int[N+1][2];//1번이 루트
		for(int i = 1; i < N; i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int dis = Integer.parseInt(st.nextToken());
		    graph[a].add(new Path(dis, b));
		    graph[b].add(new Path(dis, a));
		}
		
		writeDepth(1, 1);
		
		while(M-- > 0){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    bw.write(getDis(a, b) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void writeDepth(int now, int d){
	   depth[now] = d;
	   Iterator<Path> it = graph[now].iterator();
	   while(it.hasNext()){
	       Path p = it.next();
	       if(depth[p.node] == 0){
	           parent[p.node][0] = now;
	           parent[p.node][1] = p.dis;
	           writeDepth(p.node, d+1);
	       }
	   }
	}
	
	static int getDis(int a, int b){
	    int distance = 0;
	    while(a != b){
	        if(depth[a] > depth[b]){
	            distance += parent[a][1];
	            a = parent[a][0];
	        }else{
	            distance += parent[b][1];
	            b = parent[b][0];
	        }
	    }
	    return distance;
	}
}
