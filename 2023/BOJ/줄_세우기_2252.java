import java.io.*;
import java.util.*;

/**
 * 위상정렬을 이용해야한다.
 * 위상정렬은 선행노드가 없는 노드들을 모아 큐에 넣어두고
 * 
 * 큐에서 하나씩 꺼내서 그 노드에 대한 후행노드들에 연결성을 제거한다. 
 * 연결성을 제거하는 과정에서 선행노드가 없는 상태가 될 경우 큐에 추가한다.
 * 
 * 이를 반복해서 큐를 다 비우게되면 정렬 완성
 */
public class 줄_세우기_2252 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prevs = new int[N+1];
        ArrayList<Integer>[] nexts = new ArrayList[N+1];
        for(int i = 1; i <= N; i++)
            nexts[i] = new ArrayList<Integer>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nexts[a].add(b);
            prevs[b]++;
        }

        
        LinkedList<Integer> queue = new LinkedList<Integer>();

        int start = 0;
        while(++start <= N)
            if(prevs[start] == 0)
                queue.add(start);

        while(!queue.isEmpty()){
            start = queue.poll();
            Iterator<Integer> it = nexts[start].iterator();
            while(it.hasNext()){
                int next = it.next();
                if(--prevs[next] == 0)
                    queue.add(next);
            }
            bw.write(start + " ");
        }
        bw.write('\n');
        bw.flush();

        br.close();
        bw.close();
            
    }
}
