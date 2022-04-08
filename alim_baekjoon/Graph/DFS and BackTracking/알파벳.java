import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1987
class Main
{
    
    static int R, C;
    static char[][] board;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		R = Integer.parseInt( st.nextToken() );
		C = Integer.parseInt( st.nextToken() );
		
		board = new char[R][];
		for(int r = 0; r < R; r++)  board[r] = br.readLine().toCharArray();
		
		boolean[] visited = new boolean[26];
		System.out.println( find(visited, 0, 0) );
	}
	
	static int[][] dir = {
	    { 0, 1},
	    { 0, -1},
	    { 1, 0},
	    {-1, 0}
	};
	
	static int find(boolean[] visited, int r, int c){
	    if( r < 0 || c < 0 || r >= R || c >= C) return 0;
	    
	    int cha = board[r][c] - 'A';
	    if( visited[cha] ) return 0;
	    
	    visited[cha] = true;
	    
	    int max = 0, tmp;
	    for( int[] d : dir ){
	        tmp = find(visited, r + d[0], c + d[1]);
	        max = max > tmp ? max : tmp;
	    }
	    
	    visited[cha] = false;
	    return max + 1;
	}
}
