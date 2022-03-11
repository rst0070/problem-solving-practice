import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        while(Q-- > 0){
            
        }
    }

    static int N, Q;
    static int[] patients = new int[200001];
    static {
        for(int i = 1; i < patients.length; i++)    patients[i] = -1;
    }
}
