import java.io.*;
import java.util.*;

/**
 * 10번 이하로 움직이는 모든 경우는 4^10 이다.
 * 시간제한이 2초이기 때문에 완전탐색은 불가능
 * 
 * 구슬 위치는 고정되어있기 때문에(+ 구슬이 멈추는 위치는 정해져있음)
 * 이를 기준으로 한 다이나믹 프로그래밍!
 * 
 * 직관적이고 접근이 편하게 데이터를 만들기
 * 
 * 이 방식으로는 아직 해결하지 못함 ㅠ
 * 무엇이 문제인가?
 * 
 */

class 구슬_탈출_2{
    static class P{
        int h, w;
        public P(int h, int w){
            super();
            this.h = h; this.w = w;
        }

        @Override
        public boolean equals(Object o){
            P p = (P)o;
            if(p.h == this.h && p.w == this.w) return true;
            return false;
        }

        @Override
        public Object clone(){
            return new P(h, w);
        }
    }

    static int H, W;
    static char[][] board;

    static  int[][][][] memo = new int[10][10][10][10];
    // [red h][red w][blue h][blue w]
    static{
        for(int a = 0; a < 10; a++)
            for(int b = 0; b < 10; b++)
                for(int c = 0; c < 10; c++)
                    for(int d = 0; d < 10; d++) memo[a][b][c][d] = -1;
    }

    public static void main(String[] args) throws Exception{

        P red = null;
        P blue = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        board = new char[H][W];

        for(int h = 0; h < H; h++){
            board[h] = br.readLine().toCharArray();
            for(int w = 0; w < W; w++){
                if(board[h][w] == 'R'){red = new P(h, w); board[h][w] = '.';}
                if(board[h][w] == 'B'){blue = new P(h, w); board[h][w] = '.';}
            }
        }

        int result = dp(0, red, blue);
        if(result >= 11) result = -1;

        System.out.println(result);

    }

    /**
     * 
     * @param count
     * @param red
     * @param blue
     * @return
     */
    static int dp(int count, P R, P B){
        if(count > 9) return 11;
        if(memo[R.h][R.w][B.h][B.w] != -1) return memo[R.h][R.w][B.h][B.w];

        int result = 11;
        for(int d = 0; d < 4; d++){

        }

        return memo[R.h][R.w][B.h][B.w] = result;
    }

    static int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    //해당  p가 구멍으로 떨어지면 true 반환
    static boolean move(P p, int d, P other){
        int nh = p.h + dir[d][0];
        int nw = p.w + dir[d][1];
        if(nh < 0 || nh  >= H || nw < 0 || nw >= W || (nh == other.h && nw == other.w) || board[nh][nw] == '#') return false;
        
        p.h = nh;
        p.w = nw;
        if(board[nh][nw] == 'O') return true;
        return move(p, d, other);
    }
}