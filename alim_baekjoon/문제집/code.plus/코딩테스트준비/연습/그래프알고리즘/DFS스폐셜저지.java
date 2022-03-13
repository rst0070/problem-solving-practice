import java.io.*;
import java.util.*;

public class DFS스폐셜저지 {
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) order.add(Integer.parseInt(st.nextToken()));

        if(order.poll()  == 1){
            System.out.println(dfs(1));
        }else{
            System.out.println(0);
        }
    }
    static int N;
    static LinkedList<Integer> order = new LinkedList<Integer>();
    static boolean[] vis = new boolean[100001];
    static ArrayList[] graph = new ArrayList[100001];
    static{
        for(int i = 1; i < 100001; i++) graph[i] = new ArrayList<Integer>();
    }


    static int dfs(int now){
        if(order.isEmpty()) return 1;

        vis[now] = true;
        while(!graph[now].isEmpty()){
            if(order.isEmpty()) return 0;
            int next = order.poll();
            if(vis[next]) return 0;

            int index = graph[now].indexOf(next);
            if(index == -1) return 0;
            graph[now].remove(index);

            if(dfs(next) == 0) return 0;
        }

        return 1;
    }

}
