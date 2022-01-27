import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/13460
/**
 * 10번 이하로 움직이는 모든 경우는 4^10 이다.
 * 시간제한이 2초이기 때문에 완전탐색은 불가능
 * 
 * 구슬 위치는 고정되어있기 때문에(+ 구슬이 멈추는 위치는 정해져있음)
 * 이를 기준으로 한 다이나믹 프로그래밍!
 * 
 * 직관적이고 접근이 편하게 데이터를 만들기
 * 
 */

class Main{
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
    static P hole;//(h, w)

    static boolean[][][][] visited = new boolean[10][10][10][10];
    // [red h][red w][blue h][blue w]

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
                if(board[h][w] == 'R'){
                    red = new P(h, w);
                    board[h][w] = '.';
                }
                if(board[h][w] == 'B'){
                    blue = new P(h, w);
                    board[h][w] = '.';
                }
                if(board[h][w] == 'O'){
                    hole = new P(h, w);
                }
            }
        }

        int result = move(1, red, blue);
        if(result == 11) result = -1;

        System.out.println(result);

    }

    static int move(int count, P red, P blue){
        int result = 11;
        if(count > 10 || visited[red.h][red.w][blue.h][blue.w]) return result;
        visited[red.h][red.w][blue.h][blue.w] = true;

        direction:
        for(int d = 0; d < 4; d++){
            P r = (P)red.clone();
            P b = (P)blue.clone();


            while(true){
                System.out.println(r.h + ", " + r.w + " | " + b.h + " | " + b.w);
                
                if(hole.equals(b)) break;//파란색이 나가면 끝
                if(wall(b, dir[d])){// 파란색이 멈춤

                    if(hole.equals(r)){result = count; break direction;}
                    if(wall(r, dir[d])){
                        result = Math.min(result, move(count + 1, r, b));
                        break;
                    }
                     r.h += dir[d][0];
                     r.w += dir[d][1];

                }else if(r.equals(new P(b.h + dir[d][0], b.w + dir[d][1]))){//파란색이 빨간색에 부딫힘
                    if(hole.equals(r)) break;//빨간색이 나가면 파란색도 나가게 돼있음.
                    if(wall(r, dir[d])){
                        result = Math.min(result, move(count + 1, r, b));
                        break;
                    }
                    
                    r.h += dir[d][0];
                    r.w += dir[d][1];
                }else {
                    b.h += dir[d][0];
                    b.w += dir[d][1];
                }
            }
        }

        return result;
    }

    static int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    static boolean wall(P pos, int[] d){
        if(board[pos.h + d[0]][pos.w + d[1]] == '#') return true;
        return false;
    }
}