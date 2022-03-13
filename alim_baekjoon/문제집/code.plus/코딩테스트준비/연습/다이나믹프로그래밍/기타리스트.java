import java.io.*;
import java.util.*;

public class 기타리스트 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)  V[i] = Integer.parseInt(st.nextToken());



    }

    static int N, S, M;
    static int[] V;

    static int dp(int v, int now){
        if()
    }
}
