import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> queue = new PriorityQueue<Long>();
            while(st.hasMoreTokens())
                queue.add(Long.parseLong(st.nextToken()));
            

            Long sum = 0L;
            while(!queue.isEmpty()){
                Long a, b;
                a = queue.poll();
                if(queue.isEmpty()){
                    sum += a;
                    break;
                }

                if(a > 1){
                    b = queue.poll() * a;
                    queue.add(b);
                }
                sum++;
            }

            bw.write(2022L*sum + "\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}