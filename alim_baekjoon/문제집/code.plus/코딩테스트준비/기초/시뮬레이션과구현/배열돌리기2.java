import java.io.*;
import java.util.*;

public class 배열돌리기2 {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int R = Integer.parseInt(st.nextToken());

        for(int h = 0; h < H; h++){
            st = new StringTokenizer(br.readLine());
            for(int w = 0 ; w < W; w++) matrix[h][w] = Integer.parseInt(st.nextToken());
        }br.close();

        int uh = 0, uw = 0, dh = H - 1, dw = W - 1;
        for(int d = (Math.min(H, W))/2; d > 0 ; d--)
            rotate(R, uh++, uw++, dh--, dw--);

        for(int h = 0; h < H; h++){
            for(int w = 0 ; w < W; w++) bw.write(matrix[h][w] + " ");
            bw.write("\n");
        }
        bw.flush();

    }

    static int[][] matrix = new int[300][300];
    static int H, W;

    static void rotate(int r, int uh, int uw, int dh, int dw){
        int size = ((dh - uh) + (dw - uw)) * 2;
        if( r >= size ) r = r % size;
        while(r > 0){
            int tmp = matrix[uh][uw];
            for(int w = uw; w < dw; w++)
                matrix[uh][w] = matrix[uh][w + 1];
            for(int h = uh; h < dh; h++)
                matrix[h][dw] = matrix[h + 1][dw];
            for(int w = dw; w > uw; w--)
                matrix[dh][w] = matrix[dh][w - 1];
            for(int h = dh; h > uh; h--)
                matrix[h][uw] = matrix[h - 1][uw];
            matrix[uh + 1][uw] = tmp;
            r--;
        }
    }
}
