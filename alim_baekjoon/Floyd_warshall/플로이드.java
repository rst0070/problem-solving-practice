import java.io.*;
import java.util.*;

public class 플로이드 {
    //https://www.acmicpc.net/problem/11404
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new long[N+1][N+1];

        for(int a = 1; a <= N; a++)
            for(int b = 1; b <= N; b++) if(a != b) graph[a][b] = INF;

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], c);
        }

        for(int k = 1; k <= N; k++){
            for(int a = 1; a <= N; a++)
                for(int b = 1; b <= N; b++)
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++) 
                if(graph[i][j] == INF)  bw.write("0 ");
                else    bw.write(graph[i][j] + " ");
            bw.write('\n');
        }

        bw.flush();
    }
    static final long INF = 100000 * 100000;
    static int N, M;
    static long[][] graph;
}
