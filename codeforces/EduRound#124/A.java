import java.io.*;
import java.util.*;
public class A {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int N = Integer.parseInt(br.readLine());
            long result = 1;
            for(int i = 1; i <= N; i++) result = result * 2;
            result--;
            bw.write(result + "\n");
        }
        bw.flush();
    }
}
