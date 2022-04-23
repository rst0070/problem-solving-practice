import java.io.*;
import java.util.*;

public class 행렬_곱셈_순서 {
    static int N;
    static int[][] mats = new int[500][2];//[][0]:r, [][1]:c
    static int[][] dp = new int[500][500];
    static{
        for(int i = 0; i < 500; i++)
            for(int j = 0; j < 500; j++)
               dp[i][j] = -1;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            mats[i][0] = r;
            mats[i][1] = c;
        }
        System.out.println(solve(0, N-1));
    }

    static int solve(int left, int right){
        if(left == right) return 0;
        if(dp[left][right] != -1) return dp[left][right];

        for(int i = left; i < right; i++){
            int val = solve(left, i) + solve(i + 1, right) + (mats[left][0] * mats[i][1] * mats[right][1]);
            if(dp[left][right] == -1 || dp[left][right] > val)
                dp[left][right] = val;
        }
        return dp[left][right];
    }
}
