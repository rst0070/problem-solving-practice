import java.io.*;
import java.util.*;

class Main
{
  //https://www.acmicpc.net/problem/1068
    //부모에서 자식방향으로만
    static boolean[][] graph = new boolean[50][50];
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		int N = Integer.parseInt( br.readLine() );
		
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int rootNum = 0;
		for(int i = 0; i < N; i++){
		    int parent = Integer.parseInt( st.nextToken() );
		    if( parent == -1 ){ rootNum = i; continue; }
		    graph[ parent ][i] = true;
		}
		
		int removeNum = Integer.parseInt( br.readLine() );
		
		for(int i = 0; i < N; i++) graph[i][ removeNum ] = false;
		
		int leapNum;
		if( removeNum == rootNum ) leapNum = 0;
		else leapNum = find( rootNum );
		
		System.out.println( leapNum );
	}
	
	static int find(int root){
	    
	    int result = 0;
	    boolean isLeap = true;
	    for(int i = 0; i < 50; i++){
	        if( graph[root][i] ){
	            result += find(i);
	            isLeap = false;
	        }
	    }
	    
	    if( isLeap ) result++;
	    return result;
	}
	
}
