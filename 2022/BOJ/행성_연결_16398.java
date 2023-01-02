import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

/**
 * 행성의 수 N
 * 플로우 관리 비용 행렬 주어짐
 * 이때 N개의 행성의 연결을 유지하는 최소 비용?
 */
class 행성_연결_16398 {

    static class Flow{
        int node1, node2;
        long cost;
        Flow(int node1, int node2, long cost){
            this.node1 = node1; this.node2 = node2; this.cost = cost;
        }
    }

    static int N;
    static int[] attacehd;
    static PriorityQueue<Flow> flows = new PriorityQueue<Flow>(
        (Flow a, Flow b)->{
            if(a.cost < b.cost) return -1;
            else if(a.cost > b.cost) return 1;
            return 0;
        }
    );

    static int parent(int node){
        if(attacehd[node] == node) return node;
        return attacehd[node] = parent(attacehd[node]);
    }

    static void union(int n1, int n2){
        n1 = parent(n1); n2 = parent(n2);
        attacehd[n1] = n2;
    }    
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        //System.out.println(N);
        attacehd = new int[N+1];
        for(int i = 1; i <= N; i++) attacehd[i] = i;

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++) st.nextToken();
            for(int j = i+1; j <= N; j++)
                flows.add(new Flow(i, j, Integer.parseInt(st.nextToken())));
        }br.close();

        int countDown = N+1;
        long cost = 0;
        while(!flows.isEmpty() && countDown > 0){
            Flow flow = flows.poll();
            if(parent(flow.node1) != parent(flow.node2)){
                union(flow.node1, flow.node2);
                cost += flow.cost;
                countDown--;
            }
        }

        System.out.println(cost);
    }
}
