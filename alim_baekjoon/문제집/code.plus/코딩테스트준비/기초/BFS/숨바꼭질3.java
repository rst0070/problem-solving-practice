import java.util.*;

class 숨바꼭질3{

    /**
     * BFS로 풀어야하는데 0초만에 이동할수 있게 됨.
     * 이를 queue에 반영하려면
     * 0초만에 이동할 수 있는것을 우선적으로 추가해주는것.
     * 
     * 우선순위를 만들어주는 여러방법을 생각해보자!
     * 큐의 앞쪽에 삽입하여 이를 만들어낼 수 있다.
     */

     static final int MAX = 200000;

    static boolean[] vis = new boolean[MAX + 1];

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();

        LinkedList<Node> position = new LinkedList<Node>();
        LinkedList<Node> queue = new LinkedList<Node>();

        queue.add(new Node(N, 0));
        vis[N] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.p == K){
                System.out.println(now.c);
                break;
            }

            if(now.p * 2 >= 0 && now.p * 2 <= MAX && !vis[now.p * 2]){
                queue.addFirst(new Node(now.p * 2, now.c));
                vis[now.p * 2] = true;
            }

            position.add(new Node(now.p + 1, now.c + 1));
            position.add(new Node(now.p - 1, now.c + 1));
            while(!position.isEmpty()){
                Node n = position.poll();
                if(n.p >= 0 && n.p <= MAX && !vis[n.p]){
                    queue.add(n);
                    vis[n.p] = true;
                }
            }
        }

        s.close();

    }

    static class Node{
        int p, c;
        public Node(int p, int c){this.p = p; this.c = c;}
    }
}