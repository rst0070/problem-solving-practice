import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 치킨_배달
{
    /**
     * 15686번 치킨_배달
     * 
     * 
     */
    static int C = 0;//치킨집 개수
    static int H = 0;//집 개수
    static int M = 0;
    static int N = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[][] house = new int[2*N][2];//집좌표저장
        int[][] chicken = new int[13][2];//치킨집좌표저장
        boolean[] cVisited = new boolean[13];//치킨집방문여부
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int value = Integer.parseInt(st.nextToken());
                switch(value){
                    case 1:
                        house[H][0] = i;house[H++][1] = j;break;
                    case 2:
                        chicken[C][0] = i; chicken[C++][1] = j;break;
                    default: break;
                }
            }
        }
        System.out.println(solve(house, chicken, cVisited, M, -1));
		br.close();
	}
	/**
	 * cVisited: 치킨집방문여부
	 * m: 선택해야할 치킨집 개수
	 * prev: 이전에 선택한 치킨집 번호
	 */
	static int solve(int[][] house, int[][] chicken, boolean[] cVisited, int m, int prev){
	    if(m == 0){
	        int result = 0;
	        for(int i = 0; i < H; i++){
	            int min = 100000;
	            for(int j = 0; j < C; j++){
	                if(!cVisited[j]) continue;
	                
	                int disH = chicken[j][0] - house[i][0];
	                int disW = chicken[j][1] - house[i][1];
	                disH = disH > 0 ? disH : disH*(-1);
	                disW = disW > 0 ? disW : disW*(-1);
	                min = min < (disH+disW) ? min : (disH+disW);
	            }
	            result += min;
	        }
	        return result;
	    }
	    
	    int result = 100000;
	    for(int i = prev+1; i <= C - m; i++){
	        cVisited[i] = true;
	        int tmp = solve(house, chicken, cVisited, m-1, i);
	        result = result < tmp ? result : tmp;
	        cVisited[i] = false;
	    }
	    return result;
	}
	
	
}
