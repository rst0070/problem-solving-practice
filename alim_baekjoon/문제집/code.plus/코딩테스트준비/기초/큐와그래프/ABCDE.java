import java.io.*;
import java.util.*;

public class ABCDE {



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new LinkedList[N];
        for(int i = 0; i < N; i++)  graph[i] = new LinkedList<Integer>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        } br.close();

        int result = 0;

        for(int i = 0; i < N; i++){
            int tmp = depth(0, i);
            if(tmp < 5) continue;

            result = 1;
            break;
        }
            
        System.out.println(result);
    }

    static int N, M;
    static LinkedList<Integer>[] graph;
    static boolean[] vis = new boolean[2000];

    static int depth(int prev, int start){
        if(vis[start]) return 0;

        vis[start] = true;
        int result = prev + 1;
        for(int i = graph[start].size(); i > 0; i--){
            if(result > 4) break;
            int next = graph[start].poll();

            result = Math.max(result, depth(prev + 1, next));

            graph[start].add(next);
        }
        vis[start] = false;

        return result;
    }
}
