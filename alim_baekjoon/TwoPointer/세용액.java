import java.io.*;
import java.util.*;
public class 세용액 {
    static int N;
    static ArrayList<Long> seq = new ArrayList<Long>(5000);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) seq.add(Long.parseLong(st.nextToken()));

        seq.sort((Long l1, Long l2)->{
            if(l1 < l2) return -1;
            if(l1 == l2) return 0;
            return 1;
        });

        long left = 0, middle = 0, right = 0;

        int i = 0, j = 1, k = 2;
        long sum = Long.MAX_VALUE;
        while(i < N - 2){
            j = i + 1;
            k = N - 1;
            while(j < k){
                long val = seq.get(i) + seq.get(j) + seq.get(k);
                if(Math.abs(val) < sum){
                    left = seq.get(i);
                    middle = seq.get(j);
                    right = seq.get(k);
                    sum = Math.abs(val);
                }
                if(val > 0) k--;
                else j++;
            }
            i++;
        }

        System.out.println(left + " " + middle + " " + right);
    }
    
}
