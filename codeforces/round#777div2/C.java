import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] board = new char[H + 1][W + 1];

            for(int h = 1; h <= H; h++){
                String s = br.readLine();
                for(int w = 1; w <= W; w++) board[h][w] = s.charAt(w - 1);
            }

            if(board[1][1] == '1'){
                bw.write("-1\n"); continue;
            }
            StringBuilder sb = new StringBuilder();
            int times = 0;
            for(int h = H; h > 0; h--){
                for(int w = W; w > 0; w--){
                    if(board[h][w] == '0') continue;
                    times++;
                    if(w > 1){ sb.append( h + " " + (w - 1) + " " + h + " " + w + "\n"); continue;}
                    
                    if(h > 1){ sb.append( (h - 1) + " " + w + " " + h + " " + w + "\n"); continue;}

                }
            }
            bw.write(times + "\n");
            bw.write(sb.toString());
        }bw.flush();
    }
    
}
