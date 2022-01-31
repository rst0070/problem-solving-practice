import java.io.*;
import java.util.*;

public class 알고스팟 {


    /**
     * 어떻게 BFS방식으로 구현할 것 인가?
     * 이미 부순 벽의 개수로 탐색의 우선순위가 결정된다.
     * 탐색을 하다가 0으로 지나가게 되면 큐의 앞쪽에 삽입하여 우선순위를 조작할 수 있음.
     */

    static int W, H;
    static char[][] board;
    static boolean[][] visited = new boolean[100][100];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new char[H][];

        for(int i = 0; i < H; i++)  board[i] = br.readLine().toCharArray();

        LinkedList<Node> queue = new LinkedList<Node>();
        LinkedList<Node> tmp = new LinkedList<Node>();
        queue.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.h == H - 1 && now.w == W - 1){
                System.out.println(now.crushed);
                break;
            }

            for(int i = 0; i < 4; i++)
                tmp.add(new Node(now.h + d[i][0], now.w + d[i][1], now.crushed));

            while(!tmp.isEmpty()){
                Node next = tmp.poll();

                if(next.h >= 0 && next.h < H && next.w >= 0 && next.w < W && !visited[next.h][next.w]){

                    if(board[next.h][next.w] == '0'){
                          queue.addFirst(next);
                    }else{
                        next.crushed++;
                        queue.add(next);
                    }

                    visited[next.h][next.w] = true;
                }
            }

        }
    }

    static int[][] d = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    static class Node{
        int crushed;
        int w, h;
        public Node(int h, int w, int crushed){
            this.h = h;
            this.w = w;
            this.crushed = crushed;
        }
    }
}
