import java.io.*;
import java.util.*;

class Main
{
  /**
   * 2776번
   */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		int testCase = Integer.parseInt( br.readLine() );
		
		while( testCase-- > 0 ){
		    int n = Integer.parseInt( br.readLine() );
		    int[] arr1 = new int[n];
		    
		    StringTokenizer st = new StringTokenizer( br.readLine() );
		    for(int i = 0; i < n; i++){ arr1[i] = Integer.parseInt( st.nextToken() ); }
		    Arrays.sort(arr1);
		    
		    int m = Integer.parseInt( br.readLine() );
		    int[] arr2 = new int[m];
		    
		    st = new StringTokenizer( br.readLine() );
		    for(int i = 0; i < m; i++){ arr2[i] = Integer.parseInt( st.nextToken() ); }
		    
		    //탐색
		    for(int M : arr2){
		        int head = 0, tail = n-1;
		        boolean exist = false;
		        
		        while( head > -1 && tail < n && head <= tail ){
		            int mid = ( head + tail ) / 2;
		            if( arr1[mid] == M ){ exist = true; break; }
		            if( arr1[mid] < M ){
		                head = mid + 1;
		            }else{
		                tail = mid - 1;
		            }
		        }
		        
		        if( exist ) bw.write('1');
		        else bw.write('0');
		        bw.write('\n');
		    }
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
