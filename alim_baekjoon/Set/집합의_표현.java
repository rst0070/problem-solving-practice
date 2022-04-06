import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1717
public class 집합의_표현 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        link = new int[N+1];
        Arrays.fill(link, -1);

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int action = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            if(action == 0){//합집합연산
                if(a == b) continue;
                union(a, b);
            }else{
                int ra = find(a);
                int rb = find(b);
                if(ra == rb) sb.append("yes\n");
                else sb.append("no\n");
            }
        }br.close();

        System.out.print(sb.toString());
    }

    static int[] link;
    static void union(int a, int b){
        int ra = find(a);
        int rb = find(b);
        if(ra == rb) return;
        if(ra < rb) link[rb] = ra;
        else link[ra] = rb;
    }

    static int find(int x){
        if(link[x] == -1) return x;
        return link[x] = find(link[x]);
    }
}
