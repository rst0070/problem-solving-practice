import java.io.*;
import java.util.*;

public class D {
    
    /**
     * 아직 못품
     * 
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());

            if(((x / d) % d) != 0) bw.write("NO\n");

            long a = (x / d) / d;

            boolean isCom = false;
            for(long i = 2; i < a; i++){
                if(a % i == 0){isCom = true; break;}
            }

            if(isCom) bw.write("YES\n");
            else bw.write("NO\n");
        }bw.flush();
    }
}
