import java.io.*;
import java.util.*;

public class 지사_배정 {

    /**
     * 배열의 정렬과정에 문제가 있었다.
     * 
     */

    static int N, S, B, R;

    static class Road implements Comparable<Road>{
        int d;
        long l;
        Road(int d, long l){this.d = d; this.l = l;}
        @Override
        public int compareTo(Road r){
            if(this.l < r.l) return -1;
            return 1;
        }
        @Override
        public Road clone(){
            return new Road(d, l);
        }
    }
    
    static LinkedList<Road>[] graph = new LinkedList[5001];
    static LinkedList<Road>[] rgraph = new LinkedList[5001];
    static long[] dist = new long[5001];
    static long[] rdist = new long[5001];
    static long[] value;
    static long[] sum = new long[5001];
    static long[][] dp = new long[5001][5001];
    static{
        for(int i = 1; i <= 5000; i++){
            graph[i] = new LinkedList<Road>();
            rgraph[i] = new LinkedList<Road>();
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int r = 0; r < R; r++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            graph[s].add(new Road(e, l));
            rgraph[e].add(new Road(s, l));
        }

        dijkstra(B+1, graph, dist);
        dijkstra(B+1, rgraph, rdist);

        value = new long[B];
        for(int b = 1; b <= B; b++)   value[b-1] = dist[b] + rdist[b];

        Arrays.sort(value);
        for(int b = 1; b <= B; b++) sum[b] = sum[b-1] + value[b-1];

        for(int b = 1; b <= B; b++)    dp[1][b] = (b - 1) * sum[b];
        
        for(int s = 2; s <= S; s++) solve(s, s, B, 0, B);

        System.out.println(dp[S][B]);
    }

    static void dijkstra(int start, LinkedList<Road>[] gr, long[] d){
        for(int i = 1; i <= N; i++) d[i] = 2147483647L;
        PriorityQueue<Road> queue = new PriorityQueue<Road>();
        queue.add(new Road(start, 0L));
        d[start] = 0L;

        while(!queue.isEmpty()){
            Road now = queue.poll();
            if(now.l > d[now.d]) continue;

            Iterator<Road> it = gr[now.d].iterator();
            while(it.hasNext()){
                Road next = it.next().clone();
                next.l += now.l;

                if(next.l < d[next.d]){
                    d[next.d] = next.l;
                    queue.add(next);
                }
            }
        }
    }

    static void solve(int s, int bLow, int bHigh, int kLow, int kHigh){
        if(bLow > bHigh) return;

        int bMid = (bLow + bHigh) / 2;
        int opt = -1;
        dp[s][bMid] = -1;

        for(int k = kLow; k <= Math.min(bMid - 1, kHigh); k++){
            long cal = dp[s - 1][k] + cost(k, bMid);
            if(dp[s][bMid] == -1 || dp[s][bMid] > cal){
                opt = k;
                dp[s][bMid] = cal;
            }
        }

        solve(s, bLow, bMid-1, kLow, opt);
        solve(s, bMid+1, bHigh, opt, kHigh);
    }

    static long cost(int i, int j){
        return (sum[j] - sum[i]) * Integer.valueOf(j - i - 1).longValue();
    }
}
