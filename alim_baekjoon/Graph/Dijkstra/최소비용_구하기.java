import java.io.*;
import java.util.*;

public class 최소비용_구하기{

    //https://www.acmicpc.net/problem/1916
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //정점의 개수
        N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) graph[i] = new LinkedList<Edge>();

        //간선의 개수
        int M = Integer.parseInt(br.readLine());
        while(M-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());//출발정점
            int b = Integer.parseInt(st.nextToken());//도작정점
            int w = Integer.parseInt(st.nextToken());//가중치
            graph[a].add( new Edge(b, w) );
        }

        StringTokenizer st = new StringTokenizer(br.readLine());    br.close();
        int start = Integer.parseInt(st.nextToken());//시작 정점
        int end = Integer.parseInt(st.nextToken());// 도착 정점

        //우선순위 큐(현재 존재하는 최소비용의 이동을 뽑아낸다.)
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(
            (Edge e1, Edge e2)->{
                if(e1.w < e2.w) return -1;
                if(e1.w == e2.w) return 0;
                return 1;
            });
        
        //시작점을 넣는다(시작점에서부터 탐색)
        queue.add(new Edge(start, 0));
        while(!queue.isEmpty()){
            Edge now = queue.poll();
            if(now.w > distance[now.n]) continue; //이미 탐색된 최소비용이 더 작을땐 더이상 탐색하지 않는다.

            //그래프에서 연결된 다음 정점들 방문하기
            Iterator<Edge> nextNodes = graph[now.n].iterator();
            while(nextNodes.hasNext()){
                Edge next = nextNodes.next();
                next.w += now.w;
                if(next.w >= distance[next.n]) continue;

                distance[next.n] = next.w;
                queue.add(next);
            }
        }

        System.out.println(distance[end]);

    }

    static int N;
    static int INF;
    static LinkedList<Edge>[] graph = new LinkedList[1001];
    static int[] distance = new int[1001];
    static{
        INF = 1000 * 100000;
        Arrays.fill(distance, INF);
    }

    static class Edge{
        int n, w;
        Edge(int n, int w){this.n = n; this.w = w;}
    }
}