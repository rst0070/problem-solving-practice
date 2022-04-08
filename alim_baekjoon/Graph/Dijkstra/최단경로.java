import java.io.*;
import java.util.*;

public class 최단경로 {

    //https://www.acmicpc.net/problem/1753

    /**
     * 다익스트라
     * https://m.blog.naver.com/ndb796/221234424646
     */


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());   E = Integer.parseInt(st.nextToken());   distance = new int[V + 1];
        for(int i = 1; i <= V; i++){graph[i] = new LinkedList<Edge>(); distance[i] = INF;}

        int startPoint = Integer.parseInt(br.readLine());

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add( new Edge(v, w) );
        }

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>((Edge e1, Edge e2)->{
            if(e1.w < e2.w) return -1;
            if(e1.w == e2.w) return 0;
            return 1;
        });

        queue.add(new Edge(startPoint, 0));
        distance[startPoint] = 0;
        while(!queue.isEmpty()){
            Edge now = queue.poll();

            if(now.w > distance[now.v]) continue;

            Iterator<Edge> nexts = graph[now.v].iterator();
            while(nexts.hasNext()){
                Edge next = nexts.next();
                next.w += now.w;
                if(distance[next.v] > next.w){queue.add(next); distance[next.v] = next.w;}
            }
        }
        
        for(int i = 1; i <= V; i++){
            if(distance[i] < INF) bw.write(distance[i] + "\n");
            else bw.write("INF\n");
        }

        bw.flush();
    }
    static final int INF = 10 * 300000 + 1;
    static int V, E;
    static LinkedList<Edge>[] graph = new LinkedList[20001];
    static int[] distance;
    static class Edge{
        int v, w;
        public Edge(int v, int w){this.v = v; this.w = w;}
    }
}
