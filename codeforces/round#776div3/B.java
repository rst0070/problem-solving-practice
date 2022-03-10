import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            int minI = l / a;   int minJ = l % a;
            int maxI = r / a;   int maxJ = r % a;
            
            int result = Math.max(minI + minJ, maxI + maxJ);
            if(minI == maxI){ sb.append(result + "\n"); continue;}

            result = Math.max(result,  maxI - 1 + a - 1);
            sb.append(result + "\n");
        }
        System.out.println(sb.toString());
    }
}
