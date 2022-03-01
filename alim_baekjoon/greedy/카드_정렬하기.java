import java.io.*;
import java.util.*;

public class 카드_정렬하기 {

    /**
     * 1715번: 그리디
     * 현재상태에서 가장 작은카드를 고른다.
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heap = new long[N+1];
        for(int i = 1; i <= N; i++) insertHeap(Long.parseLong(br.readLine()));

        long result = 0;
        while(N > 1){
            long a = pollHeap();
            long b = pollHeap();

            result += a + b;
            if(current == 0)    break;
            
            
            insertHeap(a + b);
        }
        System.out.println(result);
    }

    static int N;
    static long[] heap;
    static int current = 0;
    static void insertHeap(long node){
        heap[++current] = node;
        sortHeap(current);
    }
    static void sortHeap(int start){
        if(start == 1 || heap[start] >= heap[start / 2]) return;
        int parent = start / 2;
        long tmp = heap[parent];

        heap[parent] = heap[start];
        heap[start] = tmp;
        sortHeap(parent);
    }
    static long pollHeap(){
        if(current == 0) return 0;

        long peak = heap[1];
        heap[1] = heap[current];
        heap[current--] = 0;


        LinkedList<Integer> positions = new LinkedList<Integer>();
        positions.add(1);
        while(!positions.isEmpty()){
            int now = positions.poll();
            
            int next = now * 2;
            if(next > current || heap[next] == 0) break;
            if( ((next + 1) <= current) && (heap[next + 1] != 0) && (heap[next] > heap[next + 1]))
                next++;

            if(heap[next] >= heap[now]) break;
            long tmp = heap[now];
            heap[now] = heap[next];
            heap[next] = tmp;
            positions.add(next);
        }

        return peak;
    }
}
