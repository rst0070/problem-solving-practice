import java.io.*;
import java.util.*;


public class 토마토 {
    static class Tomato{
        int h, w, d;
        public Tomato(int h, int w, int d){this.h = h; this.w = w;this.d = d;}
    }
    static int H, W;
    static int[][] board;
    static boolean[][] vis;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Tomato> queue = new LinkedList<Tomato>();
        LinkedList<Tomato> adj = new LinkedList<Tomato>();

        

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][W];
        vis = new boolean[H][W];

        int numOfT = H * W;//토마토 개수
        int countT = 0;//익은 토마토 개수 세기
        int result = 0;

        for(int h = 0; h < H; h++){
            st = new StringTokenizer(br.readLine());
            for(int w = 0; w < W; w++){
                board[h][w] = Integer.parseInt(st.nextToken());
                if(board[h][w] == 1){
                    queue.add(new Tomato(h, w, 0));
                    vis[h][w] = true;
                }else if(board[h][w] == -1) numOfT--;
            }
        }


        while(!queue.isEmpty()){
            
            Tomato now = queue.poll();

            countT++;
            result = now.d;

            adj.add(new Tomato(now.h + 1, now.w, now.d + 1));
            adj.add(new Tomato(now.h - 1, now.w, now.d + 1));
            adj.add(new Tomato(now.h, now.w + 1, now.d + 1));
            adj.add(new Tomato(now.h, now.w - 1, now.d + 1));
            while(!adj.isEmpty()){
                Tomato next = adj.poll();
                if(next.h < 0 || next.w < 0 || next.h >= H || next.w >= W) continue;
                if(vis[next.h][next.w] || board[next.h][next.w] == -1) continue;
                queue.add(next);
                vis[next.h][next.w] = true;
            }
        }

        if(countT != numOfT) System.out.println(-1);
        else System.out.println(result);

    }
}
