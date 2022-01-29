import java.util.*;

class Main {
    
    static boolean[] visited = new boolean[200001];
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        LinkedList<Node> queue = new LinkedList<Node>();
        LinkedList<Integer> position = new LinkedList<Integer>();

        queue.add(new Node(n, 0));
        visited[n] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.p == x){
                System.out.println(now.c);
                break;
            }

            position.add(now.p - 1);
            position.add(now.p + 1);
            position.add(now.p * 2);
            while( !position.isEmpty() ){
                int p = position.poll();
                if(p >= 0 && p < 200001 && !visited[p]){
                    queue.add(new Node(p, now.c + 1));
                    visited[p] = true;
                }
            }
        }
        
    }

    static class Node{
        int p, c;
        public Node(int p, int c){this.p = p; this.c = c;}
    }
}
