import java.io.*;
import java.util.*;

public class C {

    /**
     * 0일때 sum의 최댓값
     * 1일때 sum의 최솟값
     */

    //static boolean[] isP = new boolean[100000];
    //static int[] sum = new int[100000];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int sum = 0;
        int isP = 0;
        int bigSum = Integer.MIN_VALUE; // puple이 아닌데 누적합 최대 -> 이 값과 초기값의 합이 puple이 아니어야
        int smallSum = Integer.MAX_VALUE; // puple인데 누적합 최소 -> 이 값과 초기값의 합이 puple이어야

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            sum += Integer.parseInt(st.nextToken());
            isP = Integer.parseInt(st.nextToken());
            if(isP == 0){
                bigSum = Math.max(bigSum, sum);
            }else{
                smallSum = Math.min(smallSum, sum);
            }
        }
        //x+bigSum < k
        //x+smallSum >= k
        bw.write((K - smallSum) + " " + (K - bigSum - 1) + "\n");
        bw.flush();
    }
}
