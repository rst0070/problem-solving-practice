import java.io.*;
import java.util.*;

public class 주사위굴리기 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        ph = Integer.parseInt(st.nextToken());
        pw = Integer.parseInt(st.nextToken());
        
        int no = Integer.parseInt(st.nextToken());

        for(int h = 0; h < H; h++){
            st = new StringTokenizer(br.readLine());
            for(int w = 0; w < W; w++) board[h][w] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        while(no-- > 0){
            int order = Integer.parseInt(st.nextToken());//동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
            
            int tmp;
            switch(order){
                case 1:
                if(pw == W - 1) continue;
                    tmp = dd;
                    dd = de;
                    de = du;
                    du = dw;
                    dw = tmp;
                    pw++;break;
                case 2:
                if(pw == 0) continue;
                    tmp = dd;
                    dd = dw;
                    dw = du;
                    du = de;
                    de = tmp;
                    pw--;break;
                case 3:
                if(ph == 0) continue;
                    tmp = dd;
                    dd = dn;
                    dn = du;
                    du = ds;
                    ds = tmp;
                    ph--;break;
                case 4:
                if(ph == H - 1) continue;
                    tmp = dd;
                    dd = ds;
                    ds = du;
                    du = dn;
                    dn = tmp;
                    ph++;break;
            }
            
            if(board[ph][pw] == 0){ board[ph][pw] = dd;}
            else{dd = board[ph][pw]; board[ph][pw] = 0;}

            bw.write(du + "\n");
        }br.close();
        bw.flush();
        bw.close();
    }

    static int H, W;
    static int ph = 0, pw = 0;
    static int dd = 0, du = 0, de = 0, dw = 0, ds = 0, dn = 0; // 주사위의 숫자들: 아래, 위, 동, 서, 남, 북
    static int[][] board = new int[20][20];
}
