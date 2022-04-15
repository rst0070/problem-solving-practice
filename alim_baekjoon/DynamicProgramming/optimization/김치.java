import java.io.*;
import java.util.*;

public class 김치 {

    //김치의 가치 : 숙성시간*꺼낼때온도 + 넣은날가치
    //long과 int 형변환 주의!!
    static int N, D;//날짜 수, 숙성시간제한(숙성시간 = 꺼낸날짜 - 넣은날짜)
    static long[] T = new long[100001];//T[i] : i번째 날의 온도(점점 내려감)
    static long[] V = new long[100001];//V[i] : i번째 날의 장독대 가치
    static long ANS = -1;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) T[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) V[i] = Long.parseLong(st.nextToken());

        solve(1, N, 1, N);
        
        System.out.println(ANS);
    }
    
    static void solve(int sH, int sT, int eH, int eT){
        if(sH > sT) return;
        int midS = (sH + sT) >> 1;
        int optE = midS;

        long result = value(midS, midS);
        for(int e = eH; e <= Math.min(eT, midS+D); e++){
            long val = value(midS, e);
            if(val > result){
                result = val;
                optE = e;
            }
        }

        ANS = Math.max(ANS, result);
        solve(sH, midS - 1, eH, optE);
        solve(midS + 1, sT, optE, eT);
    }

    static long value(int start, int end){
        return ((end - start) * T[end]) + V[start];
    }
}
