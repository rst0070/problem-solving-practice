import java.io.*;
import java.util.*;

public class A {

    /**
     * 점프를 한번만 한다는 조건을 이해못함.
     */
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] board = new int[n];
            for(int i = 0; i < n; i++)  memo[i] = -1;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)  board[i] = Integer.parseInt(st.nextToken());

            int start = 0;
            bw.write(moving(board, 0) + "\n");
            
        }br.close();
        bw.flush();
        bw.close();
    }

}
