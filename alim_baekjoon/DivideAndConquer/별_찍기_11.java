import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class 별_찍기_11
{
    /**
     * 2448번 별 찍기 - 11
     * h: 24
     * w: 7 + 8*5 = 47
     * 
     * 6 11
     * w = h*2 -1
     */ 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int H = Integer.parseInt(br.readLine());
		int W = 2*H -1;
		
		char[][] result = new char[H][W+1];
		for(int h = 0; h < H; h++){
		    for(int w = 0; w < W; w++)
		        result[h][w] = ' ';
		    result[h][W] = '\n';
		}
	    draw(result, 0, W/2, H-1, 0);
		
		for(int h = 0; h < H; h++){
		    bw.write(result[h], 0, W+1);
		}
		bw.flush();
		br.close();
	}
	
	/**
	 * top: 가장 위 좌표
	 * b: 가장 왼쪽 아래 좌표.
	 */
	static void draw(char[][] result, int topH, int topW, int bH, int bW){
	    if((bH - topH) == 2){
	        result[topH][topW] = '*';
	        result[topH+1][topW-1] = '*';
	        result[topH+1][topW+1] = '*';
	        for(int w = topW-2; w <= topW+2; w++)
	            result[topH+2][w] = '*';
	        return;
	    }
	    
	    int H = bH - topH + 1;
	    draw(result, topH, topW, bH - (H/2), bW + (H/2));
	    
	    draw(result, topH + (H/2), topW - (H/2), bH, bW);
	    
	    draw(result, topH + (H/2), topW + (H/2), bH, topW + 1);
	}
}
