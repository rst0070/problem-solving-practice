import java.util.*;
import java.io.*;

public class 웜홀 {

    //https://www.acmicpc.net/problem/1865

    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            LinkedList<Edge> edges = new LinkedList<Edge>();
            int[] dist = new int[N+1];
            for(int i = 2; i <= N; i++) dist[i] = INF;

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges.add(new Edge(u, v, w));
                edges.add(new Edge(v, u, w));
            }
            
            for(int i = 0; i < W; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges.add(new Edge(u, v, -w));
            }

            boolean timeDecrease = false;
            nloop:
            for(int i = 0; i < N; i++){
                Iterator<Edge> it = edges.iterator();
                while(it.hasNext()){
                    Edge ed = it.next();
                    if((dist[ed.u] + ed.w) < dist[ed.v]){//ed.u가 방문되지 않은경우에서 음의 사이클이 존재할 수 있다. 따라서 ed.u의 방문여부를 확인하지 말자
                        dist[ed.v] = dist[ed.u] + ed.w;
                        if(i == N - 1){timeDecrease = true; break nloop;}
                    }
                }
            }

            if(timeDecrease) bw.write("YES\n");
            else bw.write("NO\n");

        }
        bw.flush();
    }

    static final int INF = 1000 * 2500 + 1;
    static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){this.u = u; this.v = v; this.w = w;}
    }
}
