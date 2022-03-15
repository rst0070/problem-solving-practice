import java.io.*;
import java.util.*;
public class F {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Tower> towers = new LinkedList<Tower>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            towers.add(new Tower(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())) );
        }

        int Q = Integer.parseInt(br.readLine());
        LinkedList<Monster> monsters = new LinkedList<Monster>();
        for(int i = 0; i < Q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            monsters.add(new Monster(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        long result = 0;
        long time = 0;
        while(!monsters.isEmpty()){
            Monster m = monsters.poll();
            for(int i = 0; i < N; i++){
                Tower t = towers.poll();
                t.timeCalc(m.time - time);
                t.dealCalc(m.deal(t));
                time = m.time;

                towers.add(t);
            }
            result += m.H;
        }
        System.out.println(result);
    }


    static class Tower{
        final long C, R;
        long currentC;
        Tower(long c, long r){
            this.C = c; this.R = r; this.currentC = c;
        }

        void timeCalc(long time){
            currentC = Math.min(C, time * R);//범위초과 오류날듯
        }

        void dealCalc(long damage){
            currentC -= damage;
        }
    }

    static class Monster{
        final long time;
        long H;
        Monster(long time, long H){
            this.time = time; this.H = H;
        }

        long deal(Tower t){
            long damage = Math.min(t.currentC, this.H);
            this.H -= damage;
            return damage;
        }
    }
}
