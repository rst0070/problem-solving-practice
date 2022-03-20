import java.io.*;
import java.util.*;

public class 구간_합_구하기5 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int y = 1; y <= N; y++){
            st = new StringTokenizer(br.readLine());
            int lineSum = 0;
            for(int x = 1; x <= N; x++){
                lineSum += Integer.parseInt(st.nextToken());
                sum[x][y] += sum[x][y - 1];
                sum[x][y] += lineSum;
            }
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());  
            int x2 = Integer.parseInt(st.nextToken());
            int result = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            bw.write(result + "\n");
        }
        bw.flush();
    }

    static int N, M;
    static int[][] sum = new int[1025][1025];
}
