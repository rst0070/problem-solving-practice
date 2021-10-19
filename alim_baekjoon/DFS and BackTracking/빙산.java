import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2573
 * a. 빙산 컴포넌트가 몇개인지 확인하는 함수
 * b. 빙산을 녹이는 함수
 * 
 * 
 * 전체 배열의 크기가 300*300 이하이고 빙산은 10이하이다. => 최대 90000*10연산 -> 시간복잡도 문제 x
 * 
 * 먼저 a를 실행하고 필요하면 b를 실행 및 카운트
 * 이때 빙산을 녹이는 최대시간이 얼마나걸릴지 상상하는것이 중요! 빙산이 모두 둘러싸여있다면..
 * 
 */
class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		N = Integer.parseInt( st.nextToken() );
		M = Integer.parseInt( st.nextToken() );
		
		map = new int[N][M];
		
		int maxIce = 0;
		for(int i = 0; i < N; i++){
		    st = new StringTokenizer( br.readLine() );
		    for(int j = 0; j < M; j++){
		        map[i][j] = Integer.parseInt( st.nextToken() );
		        if( map[i][j] > maxIce ) maxIce = map[i][j];
		    }
		}
		int count = 0;
		if(N > M) maxIce = maxIce * N;
		else maxIce = maxIce * M;
		while(maxIce > 0){
		    if(isOverTwoComponents()) break;
		    melt();
		    maxIce--;
		    count++;
		}
		if(maxIce == 0) System.out.println(0);
		else System.out.println(count);
	}
	
	static int N, M;
	static int[][] map;
	static class Pair{
	    int h, w;
	    public Pair(int h, int w){ this.h = h; this.w = w; }
	}
	
	//그래프상 컴포넌트가 두개이상인지 반환
	static boolean isOverTwoComponents(){
	    boolean[][] visited = new boolean[N][M];
	    int count = 0;
	    for(int i = 0; i < N; i++)
	        for(int j = 0; j < M; j++)
	            if( map[i][j] > 0 && !visited[i][j] ){
	                if( count > 0 ) return true;
	                count++;
	                LinkedList<Pair> stack = new LinkedList<Pair>();
	                stack.push(new Pair(i, j));
	                visited[i][j] = true;
	                while(!stack.isEmpty()){
	                    Pair now = stack.pop();
	                    if( (now.h + 1) < N && map[now.h+1][now.w] > 0 && !visited[now.h+1][now.w] ){
	                        stack.push(new Pair(now.h+1, now.w));
	                        visited[now.h+1][now.w] = true;
	                    }
	                    if( (now.h - 1) > -1 && map[now.h-1][now.w] > 0 && !visited[now.h-1][now.w] ){
	                        stack.push(new Pair(now.h-1, now.w));
	                        visited[now.h-1][now.w] = true;
	                    }
	                    if( (now.w + 1) < M && map[now.h][now.w+1] > 0 && !visited[now.h][now.w+1] ){
	                        stack.push(new Pair(now.h, now.w+1));
	                        visited[now.h][now.w+1] = true;
	                    }
	                    if( (now.w - 1) > -1 && map[now.h][now.w-1] > 0 && !visited[now.h][now.w-1] ){
	                        stack.push(new Pair(now.h, now.w-1));
	                        visited[now.h][now.w-1] = true;
	                    }
	                }
	            }
	        
	    
	    return false;
	}
	
	static void melt(){
	    boolean[][] visited = new boolean[N][M];
	    int[][] nonWater = new int[N][M];
	    for(int i = 0; i < N; i++)
	        for(int j = 0; j < M; j++)
	            if( map[i][j] > 0 && !visited[i][j] ){
	                LinkedList<Pair> stack = new LinkedList<Pair>();
	                stack.push( new Pair(i, j) );
	                visited[i][j] = true;
	                while(!stack.isEmpty()){
	                    Pair now = stack.pop();
	                    if( (now.h + 1) < N && map[now.h+1][now.w] > 0){
	                        if(!visited[now.h+1][now.w]){
	                            stack.push(new Pair(now.h+1, now.w));
	                            visited[now.h+1][now.w] = true;
	                        }
	                        nonWater[now.h][now.w]++;
	                    }
	                    if( (now.h - 1) > -1 && map[now.h-1][now.w] > 0 ){
	                        if( !visited[now.h-1][now.w] ){
	                            stack.push(new Pair(now.h-1, now.w));
	                            visited[now.h-1][now.w] = true;
	                        }
	                        nonWater[now.h][now.w]++;
	                    }
	                    if( (now.w + 1) < M && map[now.h][now.w+1] > 0 ){
	                        if( !visited[now.h][now.w+1] ){
	                            stack.push(new Pair(now.h, now.w+1));
	                            visited[now.h][now.w+1] = true;
	                        }
	                        nonWater[now.h][now.w]++;
	                    }
	                    if( (now.w - 1) > -1 && map[now.h][now.w-1] > 0 ){
	                        if( !visited[now.h][now.w-1] ){
	                            stack.push(new Pair(now.h, now.w-1));
	                            visited[now.h][now.w-1] = true;
	                        }
	                        nonWater[now.h][now.w]++;
	                    }
	                }
	            }
	    for(int i = 0; i < N; i++)
	        for(int j = 0; j < M; j++)
	            map[i][j] = map[i][j] - 4 + nonWater[i][j];
	}
	
}
