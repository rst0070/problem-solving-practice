import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기
{
  //2096번
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int N = Integer.parseInt(br.readLine());
		int[][][] memo = new int[N][3][2];// [i][j][0]: i번째 줄에서 j번째를 택했을때 최대값.[i][j][1]: 최솟값.
		
		int[][] board = new int[N][3];
		for(int i = 0; i < N; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j = 0; j < 3; j++){
		        board[i][j] = Integer.parseInt(st.nextToken());
		        memo[i][j][0] = -1;
		        memo[i][j][1] = -1;
		    }
		}
		
		find(board, N, 0, 0, memo);
		find(board, N, 0, 1, memo);
		find(board, N, 0, 2, memo);
		int min, max;
		min = memo[0][0][1] < memo[0][1][1] ? memo[0][0][1] : memo[0][1][1];
		min = min < memo[0][2][1] ? min : memo[0][2][1];
		max = memo[0][0][0] > memo[0][1][0] ? memo[0][0][0] : memo[0][1][0];
		max = max > memo[0][2][0] ? max : memo[0][2][0];
		
		System.out.println(max+" "+min);
		br.close();
	}
	
	static void find(int[][] board, int N, int h, int w, int[][][] memo){
	    if(h >= N) return;
	    if(memo[h][w][0] != -1) return;
	    
	    memo[h][w][0] = board[h][w];
	    memo[h][w][1] = board[h][w];
	    if(h == N-1) return;
	    
	    switch(w){
	        case 0:
	        find(board, N, h+1, w, memo);
	        find(board, N, h+1, w+1, memo);
	        memo[h][w][0] += memo[h+1][w][0] > memo[h+1][w+1][0] ? memo[h+1][w][0] : memo[h+1][w+1][0];
	        memo[h][w][1] += memo[h+1][w][1] < memo[h+1][w+1][1] ? memo[h+1][w][1] : memo[h+1][w+1][1];
	        break;
	        case 1:
	        find(board, N, h+1, w, memo);
	        find(board, N, h+1, w+1, memo);
	        find(board, N, h+1, w-1, memo);
	        int tmp = memo[h+1][w][0] > memo[h+1][w+1][0] ? memo[h+1][w][0] : memo[h+1][w+1][0];
	        memo[h][w][0] += tmp > memo[h+1][w-1][0] ? tmp : memo[h+1][w-1][0];
	        tmp = memo[h+1][w][1] < memo[h+1][w-1][1] ? memo[h+1][w][1] : memo[h+1][w-1][1];
	        memo[h][w][1] += tmp < memo[h+1][w+1][1] ? tmp : memo[h+1][w+1][1];
	        break;
	        case 2:
	        find(board, N, h+1, w, memo);
	        find(board, N, h+1, w-1, memo);
	        memo[h][w][0] += memo[h+1][w][0] > memo[h+1][w-1][0] ? memo[h+1][w][0] : memo[h+1][w-1][0];
	        memo[h][w][1] += memo[h+1][w][1] < memo[h+1][w-1][1] ? memo[h+1][w][1] : memo[h+1][w-1][1];
	        break;
	    }
	    
	}
	
	
}
