import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10026
class Main
{
    static int N;
    static char[][] map;
    static boolean[][] vis1 = new boolean[100][100];
    static boolean[][] vis2 = new boolean[100][100];
    static int count1 = 0;
    static int count2 = 0;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in  ) );
		N = Integer.parseInt( br.readLine() );
		map = new char[N][];
		
		for(int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
		
		for(int x = 0; x < N; x++)
		    for(int y = 0; y < N; y++)
		        if( !vis1[x][y] ){
		            dfs1( map[x][y], x, y);
		            count1++;
		        }
		for(int x = 0; x < N; x++)
		    for(int y = 0; y < N; y++)
		        if( !vis2[x][y] ){
		            dfs2( map[x][y], x, y);
		            count2++;
		        }
		System.out.println(count1+" "+count2);
	}
	
	static void dfs1(char prev, int x, int y){
	    if(x < 0 || x >= N || y < 0 || y >= N || vis1[x][y] || map[x][y]!=prev ) return;
	    
	    vis1[x][y] = true;
	    dfs1(prev, x+1, y);
	    dfs1(prev, x-1, y);
	    dfs1(prev, x, y+1);
	    dfs1(prev, x, y-1);
	}
	
	static void dfs2(char prev, int x, int y){
	    if(x < 0 || x >= N || y < 0 || y >= N || vis2[x][y] || !same(prev, map[x][y]) ) return;
	    
	    vis2[x][y] = true;
	    dfs2(prev, x+1, y);
	    dfs2(prev, x-1, y);
	    dfs2(prev, x, y+1);
	    dfs2(prev, x, y-1);
	}
	
	static boolean same(char a, char b){
	    if( (a=='R'&&b=='G') || (a=='G'&&b=='R') ) return true;
	    if( a == b ) return true;
	    return false;
	}
}
