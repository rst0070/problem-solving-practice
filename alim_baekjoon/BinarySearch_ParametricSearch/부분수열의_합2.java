import java.io.*;
import java.util.*;

public class 부분수열의_합2 {
    static int N, S;
    static int[] seq;
    //https://www.acmicpc.net/problem/1208
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)  seq[i] = Integer.parseInt(st.nextToken());

        
    }


    static int find(int start, int end){
        if(start > end) return 0;
        int mid = (start + end) >> 1;

    }
}
