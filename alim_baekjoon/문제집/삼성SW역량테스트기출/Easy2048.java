import java.io.*;
import java.util.*;

public class Easy2048 {

    /**
     * 재귀 방식을 이용해서 탐색(기저 사례를 이용해 종료)
     * 보드를 밀어서 합치는 과정을 큐로 구현함
     */
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        queue = new LinkedList[N];
        for(int i = 0; i < N; i++)  queue[i] = new LinkedList<Integer>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(find(board, 0));
    }

    static int N;

    static int find(int[][] board, int count){
        int result = 0;
        if(count == 5){//최대값을 찾기
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)  result = Math.max(result, board[i][j]);
            return result;
        }

        result = Math.max(result, find(left(board), count + 1));
        result = Math.max(result, find(right(board), count + 1));
        result = Math.max(result, find(up(board), count + 1));
        result = Math.max(result, find(down(board), count + 1));

        return result;
    }

    static LinkedList<Integer>[] queue;

    //오른쪽에서 왼쪽으로
    static int[][] left(int[][] B){
        int[][] board = new int[N][N];
        for(int h = 0; h < N; h++){
            for(int w = 0; w < N; w++)
                if(B[h][w] != 0) queue[h].add(B[h][w]);
        }
        
        for(int h = 0; h < N; h++){
            for(int w = 0; w < N; w++){
                if(queue[h].isEmpty()){board[h][w] = 0; continue;}

                int top = queue[h].poll();
                if(queue[h].isEmpty()){board[h][w] = top; continue;}

                if(queue[h].peek() == top){queue[h].poll(); board[h][w] = 2 * top;}
                else board[h][w] = top;
            }
            //queue[h].clear();
        }
            
        return board;
    }

    //왼쪽에서 오른쪽으로
    static int[][] right(int[][] B){
        int[][] board = new int[N][N];
        for(int h = 0; h < N; h++){
            for(int w = N - 1; w > -1; w--)
                if(B[h][w] != 0) queue[h].add(B[h][w]);
        }
        
        for(int h = 0; h < N; h++){
            for(int w = N - 1; w > -1; w--){
                if(queue[h].isEmpty()){board[h][w] = 0; continue;}

                int top = queue[h].poll();
                if(queue[h].isEmpty()){board[h][w] = top; continue;}
                if(queue[h].peek() == top){queue[h].poll(); board[h][w] = 2 * top;}
                else board[h][w] = top;
            }
        }
        return board;
    }

    //아래에서 위로
    static int[][] up(int[][] B){
        int[][] board = new int[N][N];
        for(int w = 0; w < N; w++){
            for(int h = 0; h < N; h++)
                if(B[h][w] != 0) queue[w].add(B[h][w]);
        }
        
        for(int w = 0; w < N; w++){
            for(int h = 0; h < N; h++){
                if(queue[w].isEmpty()){board[h][w] = 0; continue;}

                int top = queue[w].poll();
                if(queue[w].isEmpty()){board[h][w] = top; continue;}
                if(queue[w].peek() == top){queue[w].poll(); board[h][w] = 2 * top;}
                else board[h][w] = top;
            }
        }

        return board;
    }

    //위에서 아래로
    static int[][] down(int[][] B){
        int[][] board = new int[N][N];
        for(int w = 0; w < N; w++){
            for(int h = N - 1; h > -1; h--)
                if(B[h][w] != 0) queue[w].add(B[h][w]);
        }
        
        for(int w = 0; w < N; w++){
            for(int h = N - 1; h > -1; h--){
                if(queue[w].isEmpty()){board[h][w] = 0; continue;}

                int top = queue[w].poll();
                if(queue[w].isEmpty()){board[h][w] = top; continue;}
                if(queue[w].peek() == top){queue[w].poll(); board[h][w] = 2 * top;}
                else board[h][w] = top;
            }
        }

        return board;
    }
}
