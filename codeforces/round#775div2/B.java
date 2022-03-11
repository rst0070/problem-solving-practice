import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)  queue.add(Integer.parseInt(st.nextToken()));

            int count = 0;
            int top = queue.poll() - 1;
            int next = queue.poll();
            while(top >= 0){

                if(next == 0){
                    while(top > 0){
                        top--;
                        count++;
                    }
                    break;
                }

                if(next == top + 1){
                    queue.add(0); queue.add(0);
                    top = queue.poll() - 1;
                }else {
                    queue.add(top);
                    top = next - 1;
                }
                next = queue.poll();
            }
            bw.write(count + "\n");
        }br.close();
        bw.flush();
        bw.close();
        
    }
}
