import java.io.*;
import java.util.*;

public class TwoDots {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = "No";

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        board = new char[H][];

        for(int h = 0; h < H; h++)
            board[h] = br.readLine().toCharArray();
        br.close();

        root:
        for(int h = 0; h < H; h++){
            for(int w = 0; w < W; w++){
                if(dfs(0, h, w, board[h][w])){
                    message = "Yes";
                    break root;
                }
            }
        }


        System.out.println(message);
    }
    static int H, W;
    static char[][] board;
    static int[][] vis = new int[50][50];
    static{
        for(int h = 0; h < 50; h++)
            for(int w = 0; w < 50; w++) vis[h][w] = -1;
    }

    static boolean dfs(int depth, int h, int w, int c){
        if(h < 0 || w < 0 || h >= H || w >= W) return false;
        if(c != board[h][w]) return false;
        if(vis[h][w] != -1){
            if((depth - vis[h][w]) >= 4) return true;
            return false;
        }

        vis[h][w] = depth;
        depth++;
        boolean result = dfs(depth, h + 1, w, c) || dfs(depth, h - 1, w, c) || dfs(depth, h, w + 1, c) || dfs(depth, h, w - 1, c);
        vis[h][w] = -1;
        return result;
    }
}
