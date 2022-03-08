import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        while(TC-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());
            bw.write(S / (N * N) + "\n");
        }
        bw.flush();
        bw.close();
    }

    /*
    static long find(long N, long n, long s){
        if(n == 0) return 0;

        long pow = N * N;
        if(calculed >= 0) return find(N, n - 1, calculed) + 1;
        return 0;
    }*/
}
