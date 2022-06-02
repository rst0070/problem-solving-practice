import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11066
public class 파일합치기 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0){
            int k = Integer.parseInt(br.readLine());
            long[] size = new long[k];
            long[] sum = new long[k];
            long[][] cost = new long[k][k];//dp[i][j] = i번째 부터 j번째까지 에대한 최적값

            for(int i = 0; i < k; i++)
                for(int j = 0; j < k;  j++)
                    cost[i][j] = -1;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < k; i++){
                size[i] = Long.parseLong(st.nextToken());
                cost[i][i] = 0;
                sum[i] = size[i];
                if(i > 0) sum[i] += sum[i-1];
            }

            for(int d = 1; d < k; d++)
                for(int  h = 0; h + d < k; h++)
                    for(int m = h; m < h + d; m++){

                        long value = cost[h][m] + cost[m+1][h+d] + sum[h+d] - sum[h] + size[h];

                        if(cost[h][h + d] == -1 || cost[h][h + d] > value)
                            cost[h][h + d] = value;
                    }                
            
            bw.write(cost[0][k-1] + "\n");
        }

        bw.flush();
    }

}
