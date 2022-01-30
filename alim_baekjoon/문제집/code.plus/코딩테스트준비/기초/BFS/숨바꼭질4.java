import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

class 숨바꼭질4 {
    
    /**
     * visited의 응용
     * String연산은 시간이 오래걸림
     * stack같은 자료구조를 우선적으로 사용하자
     */

    static final int MAX = 200000;
    static int[] visited = new int[MAX + 1];
    static{
        for(int i = 0; i <= MAX; i++) visited[i] = -1;
    }
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = s.nextInt();
        int K = s.nextInt();
        LinkedList<Node> queue = new LinkedList<Node>();
        LinkedList<Node> position = new LinkedList<Node>();
        Stack<Integer> path = new Stack<Integer>();


        queue.add(new Node(n, 0));
        visited[n] = MAX + 1;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.p == K){
                bw.write(now.c + "\n");
                int prev = now.p;
                while(prev != MAX + 1){
                    path.add(prev);
                    prev = visited[prev];
                }

                while(!path.isEmpty()){
                    bw.write(path.pop() + " ");
                }
                break;
            }

            position.add(new Node(now.p - 1, now.c + 1));
            position.add(new Node(now.p + 1, now.c + 1));
            position.add(new Node(now.p * 2, now.c + 1));
            while( !position.isEmpty() ){
                Node next = position.poll();
                if(next.p >= 0 && next.p < 200001 && visited[next.p] == -1){
                    queue.add(next);
                    visited[next.p] = now.p;
                }
            }
        }
        s.close();
        
        bw.flush();
        bw.close();
    }

    static class Node{
        int p, c;
        String prev;
        public Node(int p, int c){this.p = p; this.c = c;}

    }
}
