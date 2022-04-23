import java.io.*;
import java.util.*;

public class 최소_스패닝_트리 {
    static int V, E;
    static int[] parent = new int[10001];
    static{
        for(int i = 1; i <= 10000; i++) parent[i] = i;
    }
    static class Edge{
        int w, u, v;
        Edge(int w, int u, int v){this.w = w; this.u = u; this.v = v;}
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>((Edge e1, Edge e2)->{return e1.w - e2.w;});
        for(int e = 0; e < E; e++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int tmp = Math.min(u, v);
            v = u + v - tmp;
            u = tmp;
            Edge ed = new Edge(w, u, v);
            queue.add(ed);
        }

        int n = 1;
        long result = 0;
        while(n < V){
            Edge e = queue.poll();
            if(findParent(e.u) == findParent(e.v)) continue;
            result += e.w;
            unionNode(e.u, e.v);
            n++;
        }
        System.out.println(result);
    }

    static int findParent(int v){
        if(v == parent[v]) return v;
        return findParent(parent[v]);
    }

    static void unionNode(int u, int v){
        int up = findParent(u);
        int vp = findParent(v);
        parent[vp] = up;
    }
}
