import java.io.*;
import java.util.*;

public class 벽_부수고_이동하기 {

    //https://www.acmicpc.net/problem/2206
    //visted에 벽을 부술수 있는 횟수를 표기하기.

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][];
        boolean[][][] vis = new boolean[N][M][2];

        for(int i = 0; i < N; i++)  map[i] = br.readLine().toCharArray();

        int result = -1;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(0, 0, 1, 1));   vis[0][0][1] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.n == N-1 && now.m == M - 1){ result = now.d; break;}

            for(int d = 0; d < dir.length; d++){
                int n = now.n + dir[d][0];  int m = now.m + dir[d][1];
                if(n < 0 || n >= N || m < 0 || m >= M) continue;
                if(map[n][m] == '0'){
                    if(!vis[n][m][now.c]){
                        queue.add(new Node(n, m, now.d + 1, now.c));
                        vis[n][m][now.c] = true;
                    }
                }else if(now.c == 1 && !vis[n][m][0]){
                    queue.add(new Node(n, m, now.d + 1, 0));
                    vis[n][m][0] = true;
                }
            }
        }

        System.out.println(result);

    }

    static int[][] dir = {
        {0, 1}, {0, -1}, {-1, 0}, {1, 0}
    };

    static class Node{
        int n, m, d, c;
        Node(int n, int m, int d, int c){this.n = n; this.m = m; this.d = d; this.c = c;}
    }
    
}
