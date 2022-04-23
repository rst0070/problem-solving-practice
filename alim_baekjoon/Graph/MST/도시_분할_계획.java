import java.io.*;
import java.util.*;

public class 도시_분할_계획 {
    static int N, M;
    static int[] root = new int[100001];
    static PriorityQueue<Road> roads = new PriorityQueue<Road>((Road r1, Road r2) -> r1.l - r2.l);
    static class Road{
        int a, b, l;
        Road(int a, int b, int l){this.a = a; this.b = b; this.l = l;}
    }
    static{
        for(int i = 1; i <= 100000; i++) root[i] = i;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            Road r = new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            roads.add(r);
        }

        int result = 0;
        while(N > 2){
            Road r = roads.poll();

            if(makeRoad(r.a, r.b)){
                result += r.l;
                N--;
            }
        }
        System.out.println(result);
    }

    static int findRoot(int house){
        if(house == root[house]) return house;
        return root[house] = findRoot(root[house]);
    }

    static boolean makeRoad(int a, int b){
        a = findRoot(a);
        b = findRoot(b);
        if(a == b) return false;
        root[a] = b;
        return true;
    }
}
