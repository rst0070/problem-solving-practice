import java.io.*;
import java.util.*;
public class 부분합 {
    //https://www.acmicpc.net/problem/1806
    static int N, S;
    static int[] seq;
    static int[] sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        seq = new int[N]; sum = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
            sum[i] = seq[i];
            if(i > 0) sum[i] += sum[i-1];
        }

        int result = 100001;
        int now = sum[0];
        int left = 0, right = 0;
        while(right < N){
            now = sum[right] - sum[left] + seq[left];
            if(now < S){
                right++;
            }else if(now == S){
                result = Math.min(result, right - left + 1);
                right++;
            }else if(now > S){
                result = Math.min(result, right - left + 1);
                left++;
            }

            if(left > right) right++;
        }
        System.out.println(result % 100001);
    }
    
}
