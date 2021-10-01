import java.io.*;
import java.util.*;

public class 두_용액
{
    
    /**
     * 이분탐색을 이용할 때는
     * 문제의 특성을 고려해 데이터 정렬의 기준과
     * 탐색의 논리를 만들어야한다.
     */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    int N = Integer.parseInt( br.readLine() );
	    int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt( st.nextToken() );
		
		//데이터 정렬
		Arrays.sort( arr );
		
		//탐색 시작
		int head = 0;
		int tail = N-1;
		
		int value = 2000000001;
		int sum;
		int a = 0, b = 0;
		
		while(head < tail){
		    sum = arr[head] + arr[tail];

		    if(sum == 0){
		        value = sum;
		        a = arr[head];
		        b = arr[tail];
		        break;
		    }
		    
		    int aS = Math.abs( sum );
		    
		    if( value > aS ){
		        value = aS;
		        a = arr[head];
		        b = arr[tail];
		    }
		    
		    if( sum < 0 ) head++;
		    else tail--;
		}
		
	    System.out.println(a+" "+b);
	    br.close();
	}
	
}
