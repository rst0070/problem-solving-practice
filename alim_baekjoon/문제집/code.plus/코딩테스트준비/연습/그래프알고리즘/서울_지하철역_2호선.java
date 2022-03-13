import java.io.*;
import java.util.*;

public class 서울_지하철역_2호선 {

    /**
     * 사이클만 찾는 목적으로 dfs를 하고
     * 나머지 사이클이 아닌 애들만 탐색해서 거리를 구하면 됨.
     * 사이클이 아닌 애들은 2그룹으로 나뉘므로 한번 dfs하고 남은 애들중에 또 dfs하면 됨.
     * 
     * 이때 현재 자신의 깊이를 알고있으므로 사이클이 발생한 지점의 깊이를 얻게된다면
     * 자신이 사이클에 속하는지 확인할 수 있음.
     * 
     * 1. 순환역들을 찾는다.
     * 2. 순환역이 아닌것들을 방문해서 순환역과의 최소거리가 얼마인지 계산한다.
     */


    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) graph[i] = new LinkedList<Integer>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph[a].add(b);    graph[b].add(a);
        }br.close();

        dfs(0, -1, 1);
        for(int i = 1; i <= N; i++){
            if(dis[i] == 0) continue;
            dfs2(-1, i);
        }

        for(int i = 1; i <= N; i++) bw.write(dis[i] + " ");
        bw.flush();
        bw.close();
    }

    static int N;
    static LinkedList<Integer>[] graph = new LinkedList[3001];
    static int[] dis = new int[3001];
    static int[] vis = new int[3001];

    static{
        for(int i = 1; i <= 3000; i++){vis[i] = -1; dis[i] = -1;}
    }

    
    static int dfs(int depth, int prev, int now){
        if(vis[now] != -1)return vis[now];
        int result = 3000;
        vis[now] = depth;
        for(int i = graph[now].size(); i > 0; i--){
            int next = graph[now].poll();
            if(next != prev)
                if(depth >= (result = dfs(depth + 1, now, next))) dis[now] = 0;
            graph[now].add(next);
        }

        return result;
    }

    static int dfs2(int prev, int now){
        if(dis[now] == 0) return 1;

        int result = -1;
        for(int i = graph[now].size(); i > 0; i--){
            int next = graph[now].poll();
            if(next != prev){
                result = dfs2(now, next);
                if(result != -1){
                    dis[now] = result;
                    result++;
                }
            }
            graph[now].add(next);
        }

        return result;
    }
}
