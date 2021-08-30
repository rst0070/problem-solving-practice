import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoardCover
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		while(testCase-- > 0){
		    st = new StringTokenizer(br.readLine());
		    int H = Integer.parseInt(st.nextToken());
		    int W = Integer.parseInt(st.nextToken());
		    int[][] board = new int[H][W];
		    for(int h = 0; h < H; h++){
		        String oneLine = br.readLine();
		        for(int w = 0; w < W; w++)  board[h][w] = oneLine.charAt(w) == '#' ? 1 : 0;// #이면 검은색(1), .이면 흰색(0)
		    }
		    System.out.println(solve(board));
		}
		br.close();
	}
	
	/*
	 * 맨 왼쪽 위쪽 의 칸을 가장 먼저 채우는 방식.
	 * 0   1   2   3
	 * #   #  ##  ##
	 * ## ##  #    #
	 * 맨위,왼쪽칸을 제외한 나머지 두 칸을 지정하는 방식을 배열로 표현
	 */
    static int[][][] types = {
        { { 0, 0}, { 1, 0}, { 1, 1} },
        { { 0, 0}, { 1, 0}, { 1, -1} },
        { { 0, 0}, { 1, 0}, { 0, 1} },
        { { 0, 0}, { 0, 1}, { 1, 1}}
    };
    
    /**
     * type의 방법으로 보드를 칠 할 수 있는지 확인후 가능하면 true 및 보드변경, 
     * 불가능하면 false 반환.
     * 배열을 재사용하기위해 else if를 사용하는것을 눈여겨 보자.
     */
	static boolean check(int[][] board, int type, int h, int w, int d){
	    boolean result = true;
	    for(int i=0; i < 3; i++){
	        int positionH = types[type][i][0] + h;
	        int positionW = types[type][i][1] + w;
	        if(positionH < 0 || positionH >= board.length || positionW < 0 || positionW >= board[0].length)
	            result = false;
	        else
	            if((board[positionH][positionW] += d) > 1) result = false;
	    }
	    
	    return result;
	}
	
	/**
	 * 보드의 상태만 가지고 문제를 해결해보자.
	 * 답의 형태에 순서가 정해져 있어야 중복이 발생하지 않는다.
	 * 맨 왼쪽 위쪽 의 칸을 가장 먼저 채우는 방식.
	 * 0   1   2   3
	 * #   #  ##  ##
	 * ## ##  #    #
	 */
	static int solve(int[][] board){
	    int h = -1, w = -1;
        rootLoop:
	    for(int i=0; i < board.length; i++)
	        for(int j = 0; j < board[0].length; j++)
	            if(board[i][j] == 0){h = i; w = j; break rootLoop;}
	    //기저사례: 모든칸을 채운경우
	    if(h == -1) return 1;
	    
	    /**
	     * 배열을 clone()으로 복사하는 방법으로 했더니 동작하지 않음.
	     * clone은 제대로 구현되지 않은듯.
	     * 
	     * 배열을 재사용하는 방법을 익혀두자.
	     */
	    int count = 0;
	    for(int type=0; type < 4; type++){
	        if(check(board, type, h, w, 1)) count += solve(board);
	        check(board, type, h, w, -1);
	    }
	    return count;
	}
}


