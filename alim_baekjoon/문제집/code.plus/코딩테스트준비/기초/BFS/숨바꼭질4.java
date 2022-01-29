import java.util.*;

class 숨바꼭질4 {
    
    static final int MAX = 200000;
    static int[] visited = new int[MAX + 1];
    static{
        for(int i = 0; i <= MAX; i++) visited[i] = -1;
    }
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int K = s.nextInt();
        LinkedList<Node> queue = new LinkedList<Node>();
        LinkedList<Node> position = new LinkedList<Node>();

        queue.add(new Node(n, 0));
        visited[n] = MAX + 1;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.p == K){
                System.out.println(now.c);
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
        
        String way = "";
        for(int i = K; i != MAX + 1; i = visited[i]){
            way = i + " " + way;
        }
        System.out.println(way);
    }

    static class Node{
        int p, c;
        String prev;
        public Node(int p, int c){this.p = p; this.c = c;}

    }
}
