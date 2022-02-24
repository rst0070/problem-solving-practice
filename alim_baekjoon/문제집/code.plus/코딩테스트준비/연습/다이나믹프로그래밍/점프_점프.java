import java.io.*;
import java.util.*;

public class 점프_점프 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        memo = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            board[i] = Integer.parseInt(st.nextToken());
            memo[i] = LIMIT;
        }br.close();

        memo[N - 1] = 0;
        int result = find(0);
        if(result >= LIMIT) result = -1;
        System.out.println(result);
    }

    static final int LIMIT = 1000;
    static int N;
    static int[] board;
    static int[] memo;

    static int find(int now){
        if(now >= N) return LIMIT;
        if(memo[now] < LIMIT) return memo[now];

        for(int i = board[now]; i >= 1; i--){
            memo[now] = Math.min(memo[now], find(now + i));
        }

        return ++memo[now];
    }
}
