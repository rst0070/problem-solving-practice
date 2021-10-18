import java.io.*;
import java.util.*;

class Main
{
    /**
     * https://www.acmicpc.net/problem/14502
     * 어떻게 접근할지모를때는 "무식하게 풀 수 있을까?"를 떠올리자
     * 벽을 다 세워보면서 브루트포스
     * 
     */
    static class Pair{
        int h, w;
        public Pair(int h, int w){this.h = h; this.w = w;}
        @Override
        protected Object clone(){
            return new Pair(h, w);
        }
    }
    
    static int[][] map;
    static int N, M;
    static int numberOfWall = 3;//벽 3개를 추가로 세운다.
    static LinkedList<Pair> virus = new LinkedList<Pair>();
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt( st.nextToken() );
		M = Integer.parseInt( st.nextToken() );
		map = new int[N][M];
		
		for(int h = 0; h < N; h++){
		    st = new StringTokenizer(br.readLine());
		    for(int w = 0; w < M; w++){
		        map[h][w] = Integer.parseInt( st.nextToken() );
		        switch(map[h][w]){
		            case 1: numberOfWall++; break;
		            case 2:
		                virus.add(new Pair(h, w));
		                map[h][w] = 3;
		                break;
		            default: break;
		        }
		    }
		        
		}
		
		buildWall(-1, 2);
		System.out.println( M*N - numberOfWall - minSpread);
	}
	
	static int minSpread = 64;
	
  // 총 n+1개의 벽을 세워야하는 상황
	static void buildWall(int prev, int n){
	    if( n == -1 ){
	        bfs();
	        return;
	    }
	    int now = prev+1;
	    
	    while(now < (N*M-n)){
	        int h = now / M;
	        int w = now % M;
	        if( map[h][w] == 0 ){
	            map[h][w] = 1;
	            buildWall(now, n-1);
	            map[h][w] = 0;
	        }
	        now++;
	    }
	}
	
	static void bfs(){
	    LinkedList<Pair> queue = (LinkedList<Pair>)virus.clone();
	    int count = 0;//바이러스가 퍼진 칸의 총 개수
	    while( !queue.isEmpty() ){
	        Pair here = queue.pollFirst();
	        int h = here.h;
	        int w = here.w;
	        count++;
	        
	        if(h < (N - 1) && map[h+1][w] == 0){
	            queue.add( new Pair(h+1, w) ); map[h+1][w] = 2;
	        }
	        if(h > 0 && map[h-1][w] == 0){
	            queue.add( new Pair(h-1, w) ); map[h-1][w] = 2;
	        }
	        if(w < (M - 1) && map[h][w+1] == 0){
	            queue.add( new Pair(h, w+1) ); map[h][w+1] = 2;
	        }
	        if(w > 0 && map[h][w-1] == 0){
	            queue.add( new Pair(h, w-1) ); map[h][w-1] = 2;
	        }
	    }
	    for(int i = 0; i < N; i++)
	        for(int j = 0; j < M; j++)
	            if(map[i][j]==2) map[i][j] = 0;
	    if( minSpread > count ) minSpread = count;
	}
}
