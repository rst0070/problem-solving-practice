import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class 팰린드롬 {
    /**
     * 백준 10942
     * 팰린드롬의 양 끝 부분을 동일한 양 만큼자르면 그것또한 팰린드롬이라는 성질이용.
     * 입출력시 시간을 줄이는 방법을 사용하기!(버퍼)
     */
    static int[] arr = new int[2000];
    static int[][] memo = new int[2000][2000];//0: 계산안함, 1: 팰린드롬아님, 2: 팰린드롬
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            bw.write(check(s, e)+47);
            bw.write('\n');
        }
        br.close();
        bw.flush();
    }

    static int check(int s, int e){
        if(s >= e) return 2;
        if(memo[s][e] != 0) return memo[s][e];

        if(arr[s] != arr[e]) return memo[s][e] = 1;
        return memo[s][e] = check(s+1, e-1);
    }
}
