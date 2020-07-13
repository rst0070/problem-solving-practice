package codejam2020;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class ParentingPartneringReturns {
    static class Node implements Comparable<Node>{
        int S, E, n;
        public Node(int s, int e, int n){
            S = s;
            E = e;
            this.n = n;
        }
        @Override
		public int compareTo(Node o) {
			if(S<o.S)
				return -1;
			if(S > o.S)
				return 1;
			return 0;
		}
    }
    
    static Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static ArrayList<Node> store = new ArrayList<Node>();
    static ArrayList<Node> s1 = new ArrayList<Node>();
    static ArrayList<Node> s2 = new ArrayList<Node>();
    public static void main(final String args[]) {

        char[] ans;
        int N, i, size1, size2;
        Node node;
        boolean check;
        final int tc = scan.nextInt();
        for(int t = 1; t<=tc; t++){
            
            N = scan.nextInt();
            ans = new char[N];

            for(i=0; i<N; i++)store.add(new Node(scan.nextInt(), scan.nextInt(), i));
            store.sort(null);

            check = true;
            for(i=0; i<N; i++){
                node = store.get(i);
                size1 = s1.size();
                size2 = s2.size();
                if(size1 == 0 || s1.get(size1-1).E <= node.S){
                    s1.add(node);
                    
                    continue;
                }
                if(size2 == 0 || s2.get(size2-1).E <= node.S){
                    s2.add(node);
                    
                    continue;
                }
                System.out.println("Case #"+t+": IMPOSSIBLE");
                check = false;
                break;
            }
            if(check){
                for(i = 0; i<s1.size(); i++)ans[s1.get(i).n] = 'C';
                for(i = 0; i<s2.size(); i++)ans[s2.get(i).n] = 'J';
                System.out.print("Case #"+t+": ");
                for(i = 0; i < N; i++)System.out.print(ans[i]);
                System.out.println();
            }
            
            store.clear();
            s1.clear();
            s2.clear();
        }
        scan.close();
    }
}