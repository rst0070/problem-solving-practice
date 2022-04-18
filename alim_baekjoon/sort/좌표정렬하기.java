import java.io.*;
import java.util.*;
public class 좌표정렬하기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws Exception{

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Point> queue = new PriorityQueue<Point>(
            (Point a, Point b)->{
                if(a.x < b.x) return -1;
                if(a.x > b.x) return 1;
                if(a.y < b.y) return -1;
                return 1; 
            });

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.add(new Point(x, y));
        }br.close();

        while(N-- > 0){
            bw.write(queue.poll().toString());
        }

        bw.flush();
        bw.close();
    }

    static class Point{
        int x, y;
        Point(int x, int y){this.x = x; this.y = y;}
        @Override
        public String toString(){return x + " " + y + "\n";}
    }
}
