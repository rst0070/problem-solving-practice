import java.io.*;
import java.util.*;

public class 앱 {

    //https://www.acmicpc.net/problem/7579
    /**
     * 비용을 기준으로 하는 dp
     * 어느정도 시간복잡도까지 가능한지 확인하기
     * 
     * 비용으로 app을 정렬하여 계속 비용당 해제할 수 있는 최대메모리 갱신
     */

    static class App{
        int mem, cost;
        App(int mem, int cost){this.mem = mem; this.cost = cost;}
    }
    static int N, M;
    static ArrayList<App> costQueue = new ArrayList<App>(100);
    static int[] dp = new int[10001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            costQueue.add(new App(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken())));
        }

        costQueue.sort((App a1, App a2)->a1.cost - a2.cost);

        for(int i = 0; i < N; i++){
            App app = costQueue.get(i);
            for(int c = (dp.length - 1 - app.cost); c >= 0; c--){
                if(c != 0 && dp[c] == 0) continue;
                dp[c + app.cost] = Math.max(dp[c + app.cost], dp[c] + app.mem);
            }
        }

        for(int i = 0; i < dp.length; i++){
            if(dp[i] >= M){
                System.out.println(i);
                break;
            }
        }
    }
}
