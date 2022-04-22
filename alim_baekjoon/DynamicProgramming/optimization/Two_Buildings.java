import java.io.*;
import java.util.*;

public class Two_Buildings {
    /**
     * n개의 건물중 i와 j를 뽑는다.(i < j)
     * 건물의 높이가 h일때
     * (Hi + Hj) * (j - i)의 최대값을 구하라
     * @param args
     * @throws Exception
     */
    static int N;
    static ArrayList<Building> iB = new ArrayList<Building>(1000000);//x가 작아질 수록 h가 같거나 작게
    static ArrayList<Building> jB = new ArrayList<Building>(1000000);//x가 커질 수록 h가 같거 작게
    static long result = 0;
    static class Building{
        int x;
        long h;
        Building(int x, long h){this.x = x; this.h = h;}
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int x = 1; x <= N; x++){
            Building b = new Building(x, Long.parseLong(st.nextToken()));

            /**
             * j번째 빌딩보다 j+a번째 빌딩의 높이가 높다면 j번째 빌딩은 의미가 없다.
             */
            while(!jB.isEmpty() && jB.get( jB.size() - 1 ).h < b.h) jB.remove(jB.size() - 1);
            jB.add(b);

            /**
             * i번째 빌딩보다 i-a번째 빌딩의 높이가 높다면 i번째 빌딩은 필요가 없다.
             */
            if(iB.isEmpty() || iB.get( iB.size() - 1 ).h < b.h) iB.add(b);
        }

        solve(0, iB.size() - 1, 0, jB.size() - 1);
        System.out.println(result);
    }

    static void solve(int si, int ei, int sj, int ej){
        if(si > ei) return;
        int i = (si + ei) >> 1;
        long value = Long.MIN_VALUE;
        int opt = -1;
        for(int j = sj; j <= ej; j++){
            long val = cost(i, j);
            if(value < val){
                value = val;
                opt = j;
            }
        }

        result = Math.max(value, result);
        solve(si, i - 1, sj, opt);
        solve(i + 1, ei, opt, ej);
    }

    static long cost(int i, int j){
        return (iB.get(i).h + jB.get(j).h) * (jB.get(j).x - iB.get(i).x);
    }
}
