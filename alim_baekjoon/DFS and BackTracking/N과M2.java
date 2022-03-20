import java.io.*;
import java.util.StringTokenizer;
public class N과M2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[M];
        find(1, 0);
        bw.flush();
    }
    static int N, M;
    static int[] ans;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void find(int now, int m) throws Exception{
        if(m == M){
            for(int i = 0; i < M; i++) bw.write(ans[i] + " ");
            bw.write('\n');
            return;
        }

        if(now > N) return;

        ans[m] = now;
        find(now + 1, m + 1);
        find(now + 1, m);
    }
}
