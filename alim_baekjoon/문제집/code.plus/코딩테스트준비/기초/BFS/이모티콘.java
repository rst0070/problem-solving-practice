import java.util.*;

public class 이모티콘 {

    static final int MAX = 2000;
    static boolean[][] vis = new boolean[MAX + 1][MAX + 1];
    public static void main(String[] args)throws Exception{
        Scanner s = new Scanner(System.in);
        int S = s.nextInt();

        LinkedList<Node> queue = new LinkedList<Node>();
        LinkedList<Node> numbers = new LinkedList<Node>();
        queue.add(new Node(1, 0, 0));
        vis[1][0] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.printed == S){
                System.out.println(now.t);
                break;
            }

            numbers.add(new Node(now.printed, now.printed, now.t + 1));
            numbers.add(new Node(now.printed + now.copied, now.copied, now.t + 1));
            numbers.add(new Node(now.printed - 1, now.copied, now.t + 1));

            while(!numbers.isEmpty()){
                Node next = numbers.poll();
                if(next.printed > -1 && next.printed <= MAX && !vis[next.printed][next.copied] ){
                    queue.add(next);
                    vis[next.printed][next.copied] = true;
                }
            }
        }

        s.close();
    }

    static class Node{
        int printed, copied, t;
        public Node(int printed, int copied, int t){
            this.printed = printed;
            this.copied = copied;
            this.t = t;
        }
    }
}
