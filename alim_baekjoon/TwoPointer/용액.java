import java.io.*;
import java.util.*;

public class 용액 {
    static int N;
    static long[] seq = new long[100000];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) seq[i] = Long.parseLong(st.nextToken());

        int left = 0;
        int right = N-1;
        long r1 = 0;
        long r2 = 0;
        long sum = Long.MAX_VALUE;
        while(left < right){
            long val = (seq[left] + seq[right]);
            if(sum > Math.abs(val)){
                sum = Math.abs(val);
                r1 = seq[left];
                r2 = seq[right];
            }
            if(val > 0) right--;
            else left++;
        }
        System.out.println(r1 + " " + r2);
    }
}
