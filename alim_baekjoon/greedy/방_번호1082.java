import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class 방_번호1082 {

    /**
     * 그리디 알고리즘.
     * 가장 긴 숫자면 좋다.
     * 길면서 가장 앞자리 숫자가 크면 좋다.
     * --> 
     * 1. 가장 긴 숫자를 만든다.
     * 2. 가장 앞자리 숫자를 큰 숫자로 바꿔본다.
     * 3. 가장 앞자리만 바꿔서안되는 경우(가장 긴 숫자의 앞자리가 0이다.) 숫자길이를 줄인다.
     * 4. 0밖에 안되는경우 예외처리
     */
    static int[] P = new int[10];
    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int minCostNum = 0;
        int minCost = 50;
        char[] result = new char[50];
        int resultLength = 0;

        StringTokenizer st = new StringTokenizer(br.readLine()  );
        for(int i = 0; i < N; i++){
            P[i] = Integer.parseInt(st.nextToken());
            if(minCost >= P[i]){
                minCost = P[i];
                minCostNum = i;
            }
        }

        M = Integer.parseInt(br.readLine());

        while(M - minCost >= 0){
            result[resultLength++] = (char)(minCostNum + '0');
            M -= minCost;
        }

        int greateDigit = 0;
        for(int idx = greateDigit; idx < resultLength; idx++){
            for(int next = N - 1; next > (int)(result[idx] - '0'); next--){
                if(M + minCost >= P[next]){
                    M = M + minCost - P[next];
                    result[idx] = (char)(next + '0');
                    break;
                }
            }

            if(result[greateDigit] == '0'){
                M = M + minCost;
                greateDigit++;
            }
        }

        String ans = "";

        if(greateDigit == resultLength) ans = "0";
        else{
            StringBuilder sb = new StringBuilder();
            for(int i = greateDigit; i < resultLength; i++) sb.append(result[i]);
            ans = sb.toString();
        }

        System.out.println(ans);
    }
}