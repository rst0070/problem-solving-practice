import java.io.*;
import java.util.*;

public class G {
    static int A, B, L;
    static long[] status = new long[100001];
    static long[] bridge = new long[100001];
    static long[] cc = new long[100001];
    static long[] cc2 = new long[100001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= A; i++){
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            long power = Long.parseLong(st.nextToken());
            status[pos] = -1L * power;
        }

        for(int i = 1; i <= B; i++){
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            long power = Long.parseLong(st.nextToken());
            bridge[pos] = power;
        }

        long power = 0L;
        long count = 0L;
        for(int i = 1; i <= L; i++){//자신이 자신위치에 영향줌
            count += cc[i];
            power -= count;
            if(bridge[i] > 0){
                count++;
                power += bridge[i];
                int tmp = Long.valueOf(bridge[i]).intValue() + i; // bridge의 효과 없어지는곳
                if(tmp <= L) cc[tmp]--;
            }
            status[i] += power;
            
        }

        power = 0L;
        count = 0L;
        boolean safe = true;
        for(int i = L-1 ; i >= 1; i--){
            count += cc2[i];
            power -= count;

            if(bridge[i+1] > 1){
                count++;
                power += bridge[i+1] - 1L;
                int tmp = i - (Long.valueOf(bridge[i+1]).intValue() - 1); 
                if(tmp > 0) cc2[tmp]--;
            }

            status[i] += power;
            if(status[i] < 0L){
                safe = false;
                break;
            }   
        }

        if(safe)
            bw.write("YES\n");
        else
            bw.write("NO\n");
        bw.flush();
    }
}
