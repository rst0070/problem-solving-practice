import java.util.*;

class 숨바꼭질3{

    /**
     * BFS로 풀어야하는데 0초만에 이동할수 있게 됨.
     * 이를 queue에 반영하려면
     * 0초만에 이동할 수 있는것을 우선적으로 추가해주는것.
     * 
     */

     static final int MAX = 200000;

    static boolean[] vis = new boolean[MAX + 1];

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();

        LinkedList<Integer> position = new LinkedList<Integer>();
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(N, 0));
        vis[N] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            System.out.println(now.p);
            if(now.p == K){
                System.out.println(now.c);
                break;
            }

            for(int p = now.p; (p + p/2) < K; p *= 2){
                if(!vis[p * 2]){
                    queue.add(new Node(p * 2, now.c));
                    vis[p * 2] = true;
                }
            }

            position.add(now.p + 1);
            position.add(now.p - 1);
            while(!position.isEmpty()){
                int p = position.poll();
                if(p >= 0 && p <= MAX && !vis[p]){
                    queue.add(new Node(p, now.c + 1));
                    vis[p] = true;
                }
            }
        }

    }

    static class Node{
        int p, c;
        public Node(int p, int c){this.p = p; this.c = c;}
    }
}