import java.io.*;

public class N_Queen {

    //https://www.acmicpc.net/problem/9663

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        System.out.println(find(0));
    }
    static int N;
    static boolean[] row = new boolean[15], col = new boolean[15], diar = new boolean[29], dial = new boolean[29];


    static int find(int h){
        if(h == N) return 1;
        
        int result = 0;
        for(int w = 0; w < N; w++){
            if(row[h] || col[w] || diar[h + w] || dial[h - w + N - 1]) continue;
            row[h] = true; col[w] = true; diar[h + w] = true; dial[h - w + N - 1] = true;
            result += find(h + 1);
            row[h] = false; col[w] = false; diar[h + w] = false; dial[h - w + N - 1] = false;
        }                
        return result;
    }

}
