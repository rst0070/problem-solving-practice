import java.util.*;
import java.io.*;

public class 퇴사 {
    
    static int N;
    static int[] T;
    static int[] P;
    static int[] memo;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = new int[N];
        P = new int[N];
        memo = new int[N];
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
            memo[i] = -1;
        }

        System.out.println(search(0));
    }

    static int search(int date){
        if(date >= N) return 0;
        if(memo[date] != -1) return memo[date];

        int a = 0, b;
        if(T[date] + date <= N) a = P[date] + search(date + T[date]);
        b = search(date + 1);

        return memo[date] = Math.max(a, b);
    }
}
