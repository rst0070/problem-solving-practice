import java.io.*;
import java.util.*;

public class 저울 {
    //2437번
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)  weights[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(weights);
        int impossible = 1;
        for(int i = 0; i < N; i++){
            if(weights[i] > impossible) break;
            impossible += weights[i];
        }

        System.out.println(impossible);
    }  
}
