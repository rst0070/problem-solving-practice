import java.io.*;
import java.util.*;

public class 집배원_한상덕 {

    //https://www.acmicpc.net/problem/2842
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new char[N][];
        altitute = new int[N][N];
        HashSet<Integer> alts = new HashSet<Integer>();

        for(int h = 0; h < N; h++){
            board[h] = br.readLine().toCharArray();
            for(int w = 0; w < N; w++){
                if(board[h][w] == 'P'){ph = h; pw = w;}
                else if(board[h][w] == 'K'){K++;}
            }
        }

        for(int h = 0; h < N; h++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int w = 0; w < N; w++){
                altitute[h][w] = Integer.parseInt(st.nextToken());
                alts.add(altitute[h][w]);
            }
        }

        System.out.println(find(alts));
    }

    static int find(HashSet<Integer> alts){
        int result = 1000000;

        Integer[] alt = alts.toArray(new Integer[0]);
        Arrays.sort(alt);
        int low = 0, high = 0;
        int right = 0, left = 0;
        while(left <= right && right < alt.length){
            low = alt[left]; high = alt[right];
            vis = new boolean[N][N];
            int visitedHomes = dfs(low, high, ph, pw);
            if(visitedHomes == K){
                result = Math.min(result, high - low);
                left++;
            }else right++;
        }
        return result;
    }

    static int N, K = 0;
    static int ph = 0, pw = 0;

    static char[][] board;
    static int[][] altitute;
    static int[] alt;
    static boolean[][] vis;
    static int[][] dir = {
        {0, 1},
        {1, 1},
        {1, 0},
        {1, -1},
        {0, -1},
        {-1, -1},
        {-1, 0},
        {-1, 1}
    };
    //정해진 low, high로 전체 집을 탐색할 수 있는가?
    static int dfs(int low, int high, int h, int w){
        if(high < low || h < 0 || h >= N || w < 0 || w >= N || vis[h][w] || low > altitute[h][w] || high < altitute[h][w]) return 0;
        
        vis[h][w] = true;

        int result = 0;
        if(board[h][w] == 'K') result++;
        for(int d = 0; d < dir.length; d++)   result += dfs(low, high, h + dir[d][0], w + dir[d][1]);

        return result;
    }
}
