import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int N = Integer.parseInt(br.readLine());
            if(ans[N] == 0){bw.write("NO\n"); continue;}
            bw.write("YES\n" + ans[1]);
            for(int i = 2; i <= N; i++) bw.write(" " + ans[i]);
            bw.write("\n");
        }bw.flush();
    }
    static int[] ans = new int[1001];
    static int last = 1;
    static{
        ans[1] = 1;
        
        int p = 2;
        for(int i = 2; i <= 1000000000; i++){
            if(p >= 20) break;
            if( (ans[p - 1] + i) <= 2*Math.abs(ans[p - 1] - i) ){
                ans[p++] = i;
            }
        }
    }
    
}
