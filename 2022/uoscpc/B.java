import java.io.*;
import java.util.*;

public class B {

    /**
     * 가장큰 m
     * 모두 합 s
     * s 이상 m의 배수
     */
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int sum = 0, m = -1;
        for(int i = 0; i < N; i++){
            int now = Integer.parseInt(br.readLine());
            if(now > m) m = now;
            sum += now;
        }

        int result = m;
        while(result < sum) result += m;
            
        bw.write(result + "\n");
        bw.flush();
    }
}
