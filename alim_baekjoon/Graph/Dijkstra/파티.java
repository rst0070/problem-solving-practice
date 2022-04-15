import java.io.*;
import java.util.*;

public class 파티 {
    static LinkedList<Road>[] graph = new LinkedList[1001];
    static LinkedList<Road>[] rgraph = new LinkedList[1001];
    static int[] distToX = new int[1001];
    static int[] distFromX = new int[1001];
    static{
        for(int i = 1; i <= 1000; i++){
            graph[i] = new LinkedList<Road>();
            rgraph[i] = new LinkedList<Road>();
            distToX[i] = 100*10000;
            distFromX[i] = 100*10000;
        }
    }
    static class Road implements Comparable<Road>{
        int dest, time;
        Road(int dest, int time){this.dest = dest; this.time = time;}
        @Override
        public int compareTo(Road r){
            if(this.time == r.time) return 0;
            if(this.time < r.time) return -1;
            return 1;
        }
        public Road clone(){return new Road(dest, time);}
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[s].add(new Road(e, t));
            rgraph[e].add(new Road(s, t));
        }

        dijkstra(graph, distFromX, X);
        dijkstra(rgraph, distToX, X);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 1; i <= N; i++){
            queue.add(distFromX[i] + distToX[i]);
        }
        System.out.println(queue.poll());
    }

    static void dijkstra(LinkedList<Road>[] gr, int[] dist, int X){
        PriorityQueue<Road> queue = new PriorityQueue<>();
        queue.add(new Road(X, 0));
        dist[X] = 0;
        while(!queue.isEmpty()){
            Road now = queue.poll();
            if(now.time > dist[now.dest]) continue;

            Iterator<Road> it = gr[now.dest].iterator();
            while(it.hasNext()){
                Road next = it.next().clone();
                next.time += now.time;
                if(next.time < dist[next.dest]){
                    dist[next.dest] = next.time;
                    queue.add(next);
                }
            }
        }
    }
}
