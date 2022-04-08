import java.io.*;
import java.util.*;

public class N과M1 {

    /**
     * https://www.acmicpc.net/problem/15649
     * 
     */

    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        br.close();

        LinkedList<Num> queue = new LinkedList<Num>();
        for(int i = 1; i <= N; i++){
            Num n = new Num(1 << i, new LinkedList<Integer>());
            n.seq.add(i);
            queue.add(n);
        }
        while(!queue.isEmpty()){
            Num now = queue.poll();
            if(now.seq.size() == M){
                bw.write(now.poll() + "");
                while(!now.seq.isEmpty())   bw.write(" " + now.poll());
                bw.write("\n");
                continue;
            }
            for(int i = 1; i <= N; i++)
                if(((1 << i) & now.visited) == 0){
                    Num next = new Num(now.visited | (1 << i), now.seq);
                    next.seq.add(i);
                    queue.add(next);
                }

        }bw.flush();
        bw.close();

    }

    static class Num{
        int visited;
        LinkedList<Integer> seq;
        public Num(int visited, LinkedList<Integer> seq){
            this.visited = visited;
            this.seq = (LinkedList<Integer>)seq.clone();
        }
        public int poll(){return seq.poll();}
        
    }
}
