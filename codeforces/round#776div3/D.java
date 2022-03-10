import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc-- > 0){
            int N = Integer.parseInt(br.readLine());
            int n = N;
            LinkedList<Integer> list = new LinkedList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++)  list.add(Integer.parseInt(st.nextToken()));

            boolean possible = true;
            int[] count = new int[N + 1];
            for(int i = 1; i <= N; i++) count[i] = 0;

            while(N > 0){
                int last = list.getLast();
                if(last == N){
                    list.removeLast(); 
                    N--; 
                    continue;
                }
                
                if(count[N] >= N - 1){
                    possible = false;
                    break;
                }
                list.addLast(list.poll());
                count[N]++;
            }

            if(possible) for(int i = 1; i <= n; i++) sb.append(count[i] + " ");
            else sb.append("-1");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
