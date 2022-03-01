import java.io.*;
import java.util.*;

public class 집합 {
    /**
     * 비트마스크공부
     * https://loosie.tistory.com/238
     */

    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        int SET = 0;
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int x = 0;
            if(st.hasMoreTokens())
                x = Integer.parseInt(st.nextToken());
            switch(order){
                case "add":
                    SET = SET | (1 << x); break;
                case "remove":
                    SET = SET & ~(1 << x); break;
                case "check":
                    int check = SET & (1 << x);
                    if(check > 0) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "toggle":
                    SET = SET ^ (1 << x); break;
                case "all":
                    SET = (1 << 21) - 1; break;
                case "empty":
                    SET = 0; break;
                default: break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
