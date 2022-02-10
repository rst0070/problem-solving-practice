import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

class 단지번호붙이기{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for(int h = 0; h < N; h++) board[h] = br.readLine().toCharArray();
        
        ArrayList<Integer> result = new ArrayList<Integer>(312);//25*25/2

        for(int h = 0; h < N; h++)
            for(int w = 0; w < N; w++)
                if(board[h][w] == '1' && !vis[h][w]) result.add(check(h, w));

        result.sort((Integer a, Integer b )->{
            if(a < b) return -1;
            if(a == b) return 0;
            return 1;
        });

        bw.write(result.size() + "\n");
        Iterator<Integer> it = result.iterator();
        while(it.hasNext()){
            bw.write(it.next() + "\n");
        }

        bw.flush();
    }

    static int N;
    static char[][] board = new char[25][];
    static boolean[][] vis = new boolean[25][25];
    static int[][] dir ={
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    static int check(int h, int w){
        if(h < 0 || w < 0 || h >= N || w >= N) return 0;
        if(board[h][w] == '0' || vis[h][w]) return 0;

        vis[h][w] = true;
        int result = 1;
        for(int d = 0; d < dir.length; d++) result += check(h + dir[d][0], w + dir[d][1]);
        
        return result;
    }
}