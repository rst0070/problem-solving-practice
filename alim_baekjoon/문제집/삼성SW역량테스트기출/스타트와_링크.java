import java.io.*;
import java.util.*;

/**
 * N명(4 <= N <= 20)
 * 각 팀은 N/2명으로 구성됨.
 * A팀과 B팀으로 나누기
 */

class 스타트와_링크{
    static final int MAX = 100 * 20 * 20;
    static int N;
    static int[][] S = new int[21][21];
    static boolean[] inA = new boolean[21];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(select(1, 0));

    }

    static int select(int n, int a){
        if(n == N+1){// 차이 계산하기.
            if(a != N/2) return MAX;

            int A = 0;
            int B = 0;
            for(int i = 1; i < N; i++)
                for(int j = i + 1; j <= N; j++){
                    if(inA[i] && inA[j]) A += S[i][j] + S[j][i];
                    else if(!inA[i] && !inA[j]) B += S[i][j] + S[j][i];
                }
            return Math.abs(A - B);            
        }
        inA[n] = true;
        int ca = select(n+1, a+1);

        inA[n] = false;
        int cb = select(n+1, a);

        return Math.min(ca, cb);
    }
}
