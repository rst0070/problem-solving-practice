import java.io.*;
/**
 * https://www.acmicpc.net/problem/1927
 * 힙의 삽입, 꺼내기
 */
class Main{
    
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		heap = new int[N*2];
		while(N-- > 0){
		    int a = Integer.parseInt(br.readLine());
		    if(a == 0){
		        bw.write(poll()+"\n");
		    }
		    else{
		        heapSize++;
		        insert(a);
		    }
		}
        br.close();
        bw.flush();
        bw.close();
	}
	
	static int[] heap;
	static int heapSize = 0;;
	static int poll(){
	    if(heapSize == 1){
	        heapSize--; return heap[1];
	    }
	    if(heapSize == 0) return 0;
	    
	    int result = heap[1];
	    heap[1] = heap[heapSize];
	    heap[heapSize] = 0;
	    heapSize--;
	    
	    int now = 1;
	    int left = 2, right = 3;
	    while( heap[left] != 0 ){//when left == 0, right is also 0
	        
	        if( heap[left] >= heap[right] && heap[right] != 0){
	            if(heap[right] >= heap[now]) break;
	            int tmp = heap[now];
	            heap[now] = heap[right];
	            heap[right] = tmp;
	            now = right;
	        }else{
	            // heap[left] < heap[right]
                if(heap[left] >= heap[now]) break;
                int tmp = heap[now];
                heap[now] = heap[left];
                heap[left] = tmp;
                now = left;
	        }
	        left = now * 2;
	        right = left + 1;
	    }
	    return result;
	}
	
	static void insert(int num){
	    heap[heapSize] = num;
	    
	    int now = heapSize;
	    int up = 0;
	    while(now > 1){
	        if(now % 2 == 0) up = now / 2;
	        else up = (now - 1) / 2;
	        
	        if( heap[up] < heap[now]) break;
	        int tmp = heap[up];
	        heap[up] = heap[now];
	        heap[now] = tmp;
	        now = up;
	    }
	}
}
