import java.io.*;
import java.util.StringTokenizer;
public class 스티커 {
    public static void main(String[] args)throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[n][2];
            int[][] memo = new int[n][2];
            for(int i = 0; i < n; i++){memo[i][0] = -1;memo[i][1] = -1;}
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)  sticker[i][0] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)  sticker[i][1] = Integer.parseInt(st.nextToken());

            bw.write(Math.max(dp(memo, sticker, 0, 0), dp(memo, sticker, 0, 1)) + "\n");
        }bw.flush();
    }

    static int dp(int[][] memo, int[][] sticker, int s, int h){
        if(s >= sticker.length) return 0;
        if(memo[s][h] != -1) return memo[s][h];

        memo[s][h] = sticker[s][h] + dp(memo, sticker, s + 1, (h + 1) % 2);
        memo[s][h] = Math.max(memo[s][h], dp(memo, sticker, s + 1, h));
        return memo[s][h];
    }
}
