import java.io.*;
import java.util.*;

public class 가장_긴_증가하는_부분_수열 {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

        startFromP(0, 1);
        System.out.println(memo[1]);
    }

    static int N;
    static int[] A = new int[1001];
    static int[] memo = new int[1001];
    static boolean[] checked = new boolean[1001];

    /**
     * 
     * 어느부분이 문제..?
     * 반례
     * 6
     * 1 5 6 2 3 4
     */

    static int startFromP(int prev, int p){
        if(p > N) return 0;
        if(prev >= A[p]) return startFromP(prev, p+1);
        if(checked[p]) return memo[p];

        memo[p] = 1 + startFromP(A[p], p+1);
        memo[p] = Math.max(memo[p], startFromP(prev, p+1));
        checked[p] = true;

        return memo[p];
    }
}
