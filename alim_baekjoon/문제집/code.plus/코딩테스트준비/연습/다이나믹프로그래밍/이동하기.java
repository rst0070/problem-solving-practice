import java.io.*;
import java.util.*;

public class 이동하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        memo = new int[H][W];
        for(int h = 0; h < H; h++){
            st = new StringTokenizer(br.readLine());
            for(int w = 0; w < W; w++){board[h][w] = Integer.parseInt(st.nextToken());  memo[h][w] = -1;}
        }br.close();
        memo[H-1][W-1] = board[H-1][W-1];

        System.out.println(find(0, 0));
    }   
    static int H, W; 
    static int[][] board = new int[1000][1000];
    static int[][] memo;
    static int[][] dir = {
        {0, 1},
        {1, 1},
        {1, 0}
    };

    static int find(int h, int w){
        if(h < 0 || h >= H || w < 0 || w >= W) return -1;
        if(memo[h][w] != -1) return memo[h][w];

        memo[h][w] = 0;
        for(int d = 0; d < dir.length; d++){
            memo[h][w] = Math.max(memo[h][w], find(h + dir[d][0], w + dir[d][1]));
        }
        
        return memo[h][w] += board[h][w];
    }
}
