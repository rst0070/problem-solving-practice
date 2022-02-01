import java.io.*;

public class _1_2_3더하기5 {
    
    /**
     * bottom up 방식으로 만들어내자
     * 같은수가 2번 이상 연속으로 나오면 안되기 때문에
     * 마지막 숫자를 결정하는 문제로 만들 수 있다.
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        

        while(tc-- > 0){
            int N = Integer.parseInt(br.readLine());
            bw.write((((memo[N][1] + memo[N][2])%divide + memo[N][3])%divide) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static final int divide = 1000000009;
    static final int MAX_N = 100000;
    static int[][] memo = new int[MAX_N + 1][4];
    static{
        memo[1][1] = 1;
        memo[1][2] = 0;
        memo[1][3] = 0;

        memo[2][1] = 0;
        memo[2][2] = 1;
        memo[2][3] = 0;

        memo[3][1] = 1;
        memo[3][2] = 1;
        memo[3][3] = 1;

        for(int i = 4; i <= MAX_N; i++){
            memo[i][1] = ( memo[i - 1][2] + memo[i - 1][3] ) % divide;
            memo[i][2] = ( memo[i - 2][1] + memo[i - 2][3] ) % divide;
            memo[i][3] = ( memo[i - 3][1] + memo[i - 3][2] ) % divide;
        }
    }
}
