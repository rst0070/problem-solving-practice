import java.io.*;
import java.util.*;

public class 짚신벌래2560 {

    static int A, B, D, N;
    static int[] dp = new int[1000001];//dp[i] : i번째 날에 발생한 개체수
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp[0] = 1;
        //자식을 발생시킬수 있는 개체
        int parents = 0;
        //현재 살아있는 개체
        int live = 1;

        for(int i = 1; i <= N; i++){
            //자식을 발생시킬수 있는 개체 갱신
            if(i >= A) parents = (parents + dp[i-A]) % 1000;
            if(i >= B) parents = (parents - dp[i-B] + 1000) % 1000;

            //자식 발생
            dp[i] = parents;
            //죽은 개체 제외
            if(i >= D) live = (live - dp[i - D] + 1000) % 1000;
            //현재 발생한 개체 저장
            live = (live + dp[i]) % 1000;
        }

        System.out.println(live);
    }
}
