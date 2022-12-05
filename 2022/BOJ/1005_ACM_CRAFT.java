import java.io.*;
import java.util.*;

class Main{

    /**
     * 각 건물이 건설되는데 필요한 건물들을 저장해두고
     * 필요한 건물들중 가장 오래걸리는걸 저장하는 방식의 dp사용
     */

    static int[] time = new int[1001];
    static LinkedList<Integer>[] required = new LinkedList[1001];
    static{
        for(int i = 1; i <= 1000; i++)
            required[i] = new LinkedList<Integer>();
    }

    static int[] dp = new int[1001]; // dp[i]: 해당 건물을 건설하기위해 최소


    static int solve(int bno){
        if(bno == 0) return 0;
        if(dp[bno] != -1) return dp[bno];

        dp[bno] = 0;
        while(!required[bno].isEmpty())
            dp[bno] = Math.max(dp[bno], solve(required[bno].poll()) );
            
        return dp[bno] += time[bno];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
            

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                required[i].clear();
                dp[i] = -1;
                time[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                required[b].add(a);
            }

            int W = Integer.parseInt(br.readLine());
            bw.write(solve(W) + "\n");

        }
        bw.flush();
    }

}