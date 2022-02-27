import java.io.*;
import java.util.*;

public class 구슬_탈출_2_BFS {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        board = new char[H][];

        Node start = new Node();
        start.cnt = 0;

        for(int h = 0; h < H; h++){
            board[h] = br.readLine().toCharArray();
            for(int w = 0; w < W; w++){
                if(board[h][w] == 'R'){
                    start.rh = h; start.rw = w; board[h][w] = '.';
                }
                if(board[h][w] == 'B'){
                    start.bh = h; start.bw = w; board[h][w] = '.';
                }
            }
        }

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(start);
        vis[start.rh][start.rw][start.bh][start.bw] = true;
        int result = -1;
        //bfs
        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.cnt > 10){result = -1; break;}
            if(board[now.bh][now.bw] == 'O') continue;
            if(board[now.rh][now.rw] == 'O'){result = now.cnt; break;}

            for(int d = 0; d < 4; d++){
                Node next = new Node(now.cnt + 1, now.rh, now.rw, now.bh, now.bw);
                move(next, d);//구슬을 이동시킨다.
                if(!vis[next.rh][next.rw][next.bh][next.bw]){
                    queue.add(next);
                    vis[next.rh][next.rw][next.bh][next.bw] = true;
                }
            }
        }

        System.out.println(result);
    }

    static int H, W;
    static char[][] board;
    static boolean[][][][] vis = new boolean[10][10][10][10];
    static class Node{
        int cnt, rh, rw, bh, bw;
        public Node(int cnt, int rh, int rw, int bh, int bw){
            this.cnt = cnt; this.rh = rh; this.rw = rw; this.bh = bh; this.bw = bw;
        }
        public Node(){}
    }

    static int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    static void move(Node p, int d){
        int rd = (p.rh * dir[d][0]) + (p.rw * dir[d][1]);
        int bd = (p.bh * dir[d][0]) + (p.bw * dir[d][1]);
        char tmp;
        if(rd > bd){//d의 방향으로 빨간공이 더 가까울때
            moveR(p, d);
            tmp = board[p.rh][p.rw];
            if(tmp != 'O') board[p.rh][p.rw] = '#';
            moveB(p, d);
            board[p.rh][p.rw] = tmp;
        }else{//파란공이 더 가까울때
            moveB(p, d);
            tmp = board[p.bh][p.bw];
            if(tmp != 'O') board[p.bh][p.bw] = '#';
            moveR(p, d);
            board[p.bh][p.bw] = tmp;
        }
    }
    //빨간공 움직이기
    static void moveR(Node p, int d){
        int nh = p.rh + dir[d][0];
        int nw = p.rw + dir[d][1];
        if(nh < 0 || nh >= H || nw < 0 || nw >= W || board[nh][nw] == '#') return;
        
        p.rh = nh; p.rw = nw;
        if(board[nh][nw] == 'O') return;
        moveR(p, d);
    }
    //파란공 움직이기
    static void moveB(Node p, int d){
        int nh = p.bh + dir[d][0];
        int nw = p.bw + dir[d][1];
        if(nh < 0 || nh >= H || nw < 0 || nw >= W || board[nh][nw] == '#') return;

        p.bh = nh; p.bw = nw;
        if(board[nh][nw] == 'O') return;
        moveB(p, d);
    }
}
