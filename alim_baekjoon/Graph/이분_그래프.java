import java.io.*;
import java.util.*;

public class 이분_그래프 {

    //https://www.acmicpc.net/problem/1707
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        testCase : while(K-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            
            color = new int[V+1];
            Arrays.fill(color, -1);
            for(int i = 1; i <= V; i++) graph[i].clear();

            while(E-- > 0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            for(int i = 1; i <= V; i++)
                if(color[i] == -1){
                    if(!isBipartite(i, 1)){sb.append("NO\n"); continue testCase;}
                }
            sb.append("YES\n");         
        }
        System.out.print(sb.toString());
    }

    static int V, E;
    static LinkedList<Integer>[] graph = new LinkedList[20001];
    static{
        for(int i = 1; i < 20001; i++) graph[i] = new LinkedList<Integer>();
    }
    static int[] color;

    static boolean isBipartite(int v, int c){
        color[v] = c;
        int nextC = (c + 1) % 2;
        while(!graph[v].isEmpty()){
            int next = graph[v].poll();
            if(color[next] == color[v]) return false;
            if(color[next] == -1 && !isBipartite(next, nextC)) return false;
        }
        return true;
    }
}
