import java.io.*;
import java.util.*;

class Main{
    /**
     * https://www.acmicpc.net/problem/2533
     * 트리에서의 동적계획법.
     * 트리구조이기 때문에( 부분구조가능 ) 동적계획법이 가능한것인가? 
     */
     
    static int N;
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];
        visited = new boolean[N+1];
        graph = new LinkedList[N+1];
        for(int i = 1; i <= N; i++){
            graph[i] = new LinkedList<Integer>();
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        br.close();
        System.out.println(Math.min(solve(1, 1), solve(1, 0)));
    }
    
    static int solve(int now, int adapt){
        if(dp[now][adapt] != -1) return dp[now][adapt];
        
        visited[now] = true;
        
        int result = 0;
        Iterator<Integer> it = (Iterator<Integer>)graph[now].iterator();
        if(adapt == 0){
            while(it.hasNext()){
                int next = it.next();
                if(visited[next]) continue;
                result += solve(next, 1);
            }
        }else{
            result++;
            while(it.hasNext()){
                int next = it.next();
                if(visited[next]) continue;
                result += Math.min(solve(next, 1), solve(next, 0));
            }
        }
        
        visited[now] = false;
        return dp[now][adapt] = result;
    }
}
