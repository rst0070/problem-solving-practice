import java.util.*;
import java.io.*;

public class D {

    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Point> queue = new LinkedList<Point>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            map[p.x][p.y] = 1;
            queue.add( p );
        }

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int dis = 1; )
        }

    }

    static short[][] map = new short[200001][200001];

    static class Point{
        int x, y;
        Point(int x, int y){this.x = x; this.y = y;}
    }

}
