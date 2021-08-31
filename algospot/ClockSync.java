import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class ClockSync
{
  /**
  스위치를 작동시키는 순서는 상관없다.
  4번 작동시키면 아무의미가 없음으로 모든 스위치를 4번씩 돌리면 그 경우는 버리는 경우.
  
  함수가 작동할때마다 하나의 스위치를 0번 부터 3번까지 작동시켜보면서 재귀호출을한다.
  이때 마지막스위치까지 모두 작동을했는데 답이 나오지 않으면 그 경우는 답을 못만들어낸 경우.
  
  문제를 변형시키는 연습!
  */
  //모든 스위치의 최대작동합은 39
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		while(testCase-- > 0){
		    int[] clocks = new int[16];
		    st = new StringTokenizer(br.readLine());
		 
		    for(int i = 0; i < 16; i++)
		        clocks[i] = Integer.parseInt(st.nextToken());
		    
		    int result = solve(clocks, 0);
		    if(result >= 40) result = -1;
		    System.out.println(result);
		}
		
	}
	
	static final int[][] switchEffect = {
	    {0, 1, 2},
	    {3, 7, 9, 11},
	    {4, 10, 14, 15},
	    {0, 4, 5, 6, 7},
	    {6, 7, 8, 10, 12},
	    {0, 2, 14, 15},
	    {3, 14, 15},
	    {4, 5, 7, 14, 15},
	    {1, 2, 3, 4, 5},
	    {3, 4, 5, 9, 13}
	};
	
	/**
	 * switchNum에 해당하는 스위치를 clocks[]에 작동시킨다.
	 */
	static void switchAction(int[] clocks, int switchNum, int times){
	    for(int i=0; i < switchEffect[switchNum].length; i++){
	        clocks[ switchEffect[switchNum][i] ] =
	        (clocks[ switchEffect[switchNum][i] ] + 3*times) % 12;
	    }
	}
	
	/**
	 * clocks: clocks have to be modified.
	 * visited[i]:  if i'th switch occured, then visited[i] is true.
	 */
	static int solve(int[] clocks, int switchNum){
	    //base case1: all clocks direct correctly.
	    boolean done = true;
	    for(int i = 0; i < clocks.length; i++)
	        if(clocks[i] != 0){ done = false; break;}
	    if(done) return 0;
	    
	    // 없을때.
	    if(switchNum > 9) return 40;
	    
	    int min = 40;
	    for(int i = 0; i < 4; i++){
	        switchAction(clocks, switchNum, i);
	        int result = solve(clocks, switchNum+1) + i;
	        min = result < min ? result : min;
	        
	        //원래대로 돌리기
	        switchAction(clocks, switchNum, 4 - i);
	    }
	    return min;
	}
}




