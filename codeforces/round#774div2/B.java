import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        while(TC-- > 0){
            String result = "NO\n";
            int N = Integer.parseInt(br.readLine());
            if(N < 3){
                bw.write(result); continue;
            }

            PriorityQueue<Long> forR = new PriorityQueue<Long>(Collections.reverseOrder());
            PriorityQueue<Long> forB = new PriorityQueue<Long>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                Long el = Long.parseLong(st.nextToken());
                forR.add(el);
                forB.add(el);
            }

            int rp = N - 1;
            int bp = 1;
            long bsum = forB.poll() + forB.poll();
            long rsum = forR.poll();

            while(bp < rp){
                if(rsum > bsum){
                    result = "YES\n";
                    break;
                }

                bsum += forB.poll();
                rsum += forR.poll();
                rp--; bp++;
            }
            bw.write(result);
        }
        bw.flush();
        bw.close();
    }
}
