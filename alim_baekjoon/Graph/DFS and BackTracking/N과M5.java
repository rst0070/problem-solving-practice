import java.io.*;
import java.util.*;

public class N과M5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        vis = new boolean[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)  arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        find(0);
        bw.flush();
    }
    static int N, M;
    static int[] arr;
    static int[] ans;
    static boolean[] vis;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void find(int m)  throws Exception{
        if(m == M){
            for(int i = 0; i < M; i++) bw.write(ans[i] + " ");
            bw.write('\n'); return;
        }


        for(int i = 0; i < N; i++){
            if(vis[i]) continue;

            ans[m] = arr[i];
            vis[i] = true;
            find(m + 1);
            vis[i] = false;
        }

    }
}
