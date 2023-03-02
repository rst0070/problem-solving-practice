import java.io.*;
import java.util.*;

/**
 * 전체길이 40인 수열에서 모든 부분 수열을 구하는것은 오랜시간이 소요된다. 2^40
 * 
 * 따라서 이를 두 부분으로 나누어 각각 부분수열을 구해보자.
 * 이것은 시간복잡도가 2 * 2^20 이므로 1초내에 해결가능하다.
 * 
 * 즉 전체 수열을 절반으로 나눠서 각각의 부분수열을 계산하는 방법으로 이 문제를 해결할 수 있다.
 */
public class 부분수열의_합_2 {

    static int N, S;
    static long COUNT = 0L;
    static int[] seq = new int[40];
    static HashMap<Integer, Long> map = new HashMap<Integer,Long>();

    static void seq1(int start, int end, int sum){
        if(start == end){
            long cnt = 1L;
            if(map.containsKey(sum))
                cnt += map.get(sum);
            map.put(sum, cnt);
            return;
        }

        seq1(start + 1, end, sum + seq[start]);
        seq1(start + 1, end, sum);
    }

    static void seq2(int start, int end, int sum){
        if(start == end){
            if(map.containsKey(S - sum))
                COUNT += map.get(S - sum);
            return;
        }

        seq2(start + 1, end, sum + seq[start]);
        seq2(start + 1, end, sum);
    }



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            seq[i] = Integer.parseInt(st.nextToken());

        seq1(0, N/2, 0);
        seq2(N/2, N, 0);
        if(S == 0) COUNT--;
        System.out.println(COUNT);
    }
}
