import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class _1로만들기2 {
    static int[] dp = new int[1000001];
    static int[] graph = new int[1000001];
    static{for(int i = 2; i < 1000001; i++) dp[i] = -1;}
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        bw.write(dfs(n) + "\n");
        for(int i = n; i >= 1; i = graph[i])
            bw.write(i + " ");
        bw.flush();
    }

    static int dfs(int now){
        if(dp[now] != -1) return dp[now];

        int result = dfs(now - 1) + 1;
        int next = now - 1;

        if(now % 3 == 0)
            if(dfs(now / 3) + 1 < result){
                result = dfs(now / 3) + 1;
                next = now / 3;
            }

        if(now % 2 == 0)
            if(dfs(now / 2) + 1 < result){
                result = dfs(now / 2) + 1;
                next = now / 2;
            }

        graph[now] = next;
        return dp[now] = result;
    }
}
