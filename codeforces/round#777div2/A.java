import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int N = Integer.parseInt(br.readLine());
            char[] r1 = new char[N];
            char[] r2 = new char[N];
            int w1 = find(r1, 0, N, 1);
            int w2 = find(r2, 0, N, 2);
            if(w1 == w2){
                bw.write(r2, 0, w2);
            }else if(w1 > w2){
                bw.write(r1, 0, w1);
            }else{
                bw.write(r2, 0, w2);
            }
            bw.write('\n');
        }bw.flush();
    }

    //return length
    static int find(char[] result, int p, int N, int start){
        if(N < start) return 0;
        result[p] = (char)(start + '0');
        return 1 + find(result, p + 1, N - start, start % 2 + 1); 
    }
}
