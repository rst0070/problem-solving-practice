import java.io.*;
import java.util.*;

public class 개미굴 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node root = new Node("", -1);
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            Node node = root;
            while(st.hasMoreTokens()){
                Node next = node.pollOrNew(st.nextToken());
                node = next;
            }
        }

        /*
        StringBuilder sb = new StringBuilder();
        while(!root.next.isEmpty()){
            find(sb, root.next.poll());
        }*/

        System.out.print(root.print());
    }

    /*
    static void find(StringBuilder sb, Node now){
        sb.append(now.print());
        while(!now.next.isEmpty()){
            find(sb, now.next.poll());
        }
    }*/

    static class Node implements Comparable<Node>{
        String text;
        int depth;
        PriorityQueue<Node> next = new PriorityQueue<Node>();
        Node(String text, int depth){
            this.text = text; this.depth = depth;
        }

        Node pollOrNew(String str){
            Node result = null;
            Iterator<Node> it = next.iterator();
            while(it.hasNext()){
                Node polled = it.next();
                if(polled.text.equals(str)){
                    result = polled;
                    break;
                }
            }
            if(result == null){
                result = new Node(str, this.depth + 1);
                next.add(result);
            }
            return result;
        }

        StringBuilder print(){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < depth; i++)  sb.append("--");
            sb.append(this.text);
            if(this.depth != -1)  sb.append("\n");

            while(!next.isEmpty()){
                sb.append(next.poll().print());
            }
            return sb;
        }

        @Override
        public int compareTo(Node n){
            return this.text.compareTo(n.text);
        }
    }
}
