import java.io.*;
import java.util.*;

public class 외판원_순회 {

    /**
     * 비트마스크, 다이나믹프로그래밍, 최대값
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            result = Math.min(result, dp(1 << i, i, i));
        }
        System.out.println(result);
    }

    static final int MAX = 1000000000;
    static int N;
    static int[][] graph = new int[17][17];
    static int[][][] memo = new int[131071][17][17];//memo[비트마스크][현재위치][도착위치]
    static{
        for(int i = 0; i < memo.length; i++)
            for(int j = 0; j < 17; j++){
                for(int k = 0; k < 17; k++) memo[i][j][k] = -1;
            }
    }

    static int dp(int vis, int now, int desti){
        if(vis != (1 << now) && now == desti){
            boolean finish = true;
            for(int i = 1; i <= N; i++)
                if((vis & (1 << i)) == 0){
                    finish = false;break;
                }
            if(finish) return 0;
            return MAX;
        }
        if(memo[vis][now][desti] != -1) return memo[vis][now][desti];
        
        int result = MAX;
        for(int i = 1; i <= N; i++){
            if(graph[now][i] == 0) continue;
            if(i != desti && (vis & (1 << i)) != 0) continue;
            result = Math.min(result, graph[now][i] + dp(vis | (1 << i), i, desti));
        }
        return memo[vis][now][desti] = result;
    }
}
