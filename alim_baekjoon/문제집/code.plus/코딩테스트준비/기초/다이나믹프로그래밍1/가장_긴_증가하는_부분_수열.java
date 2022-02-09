import java.io.*;
import java.util.*;

public class 가장_긴_증가하는_부분_수열 {

    /**
     * 재귀함수 startFromP가 p에서 시작하지 않는 경우를 계산하는 실수함
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

        
        int result = 0;
        for(int i = 1; i <= N; i++)
            if(result < startFromP(i)) result = startFromP(i);
        System.out.println(result);
    }

    static int N;
    static int[] A = new int[1001];
    static int[] memo = new int[1001];


    //A[p]를 포함하는 경우만
    static int startFromP(int p){
        if(p > N) return 0;
        if(memo[p] > 0) return memo[p];

        memo[p] = 1;
        for(int i = p + 1; i <= N; i++){
            if(A[p] < A[i]) memo[p] = Math.max(memo[p], 1 + startFromP(i));
        }

        return memo[p];
    }
}
