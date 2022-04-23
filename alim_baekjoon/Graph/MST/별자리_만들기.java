import java.io.*;
import java.util.*;

import javax.swing.text.Position;

public class 별자리_만들기 {
    static int N;
    static int[] root = new int[100];
    static double[][] position = new double[100][2];
    static PriorityQueue<Dist> lines = new PriorityQueue<Dist>((Dist a, Dist b)->{
        if(a.distance < b.distance) return -1;
        if(a.distance == b.distance) return 0;
        return 1;
    });
    static class Dist{
        int a, b;
        double distance;
        Dist(int a, int b, double distance){this.a = a; this.b = b; this.distance = distance;}
    }
    static{
        for(int i = 0; i < 100; i++) root[i] = i;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            position[i][0] = x;
            position[i][1] = y;

            if(i > 0){
                for(int j = 0; j < i; j++){
                    double distance = Math.pow(position[i][0] - position[j][0], 2) + Math.pow(position[i][1] - position[j][1], 2);
                    distance = Math.sqrt(distance);
                    lines.add(new Dist(j, i, distance));
                }
            }
        }

        double result = 0;
        while(N > 1){
            Dist d = lines.poll();
            if(union(d.a, d.b)){
                result += d.distance;
                N--;
            }
        }
        System.out.println(result);
    }

    static int findRoot(int star){
        if(root[star] == star) return star;
        return root[star] = findRoot(root[star]);
    }
    static boolean union(int a, int b){
        a = findRoot(a);
        b = findRoot(b);
        if(a == b) return false;
        root[a] = b;
        return true;
    }
}
