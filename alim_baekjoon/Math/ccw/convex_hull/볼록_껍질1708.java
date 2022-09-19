import java.io.*;
import java.util.*;

public class 볼록_껍질1708 {

    /**
     * 점들을 정렬하는 단계와 점들을 탐색하는 단계로 나눠져 있다.
     * 
     */

    //https://www.geeksforgeeks.org/convex-hull-set-2-graham-scan/

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = fromSt(st);
        
        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            Point point = fromSt(st);

            if(start.y < point.y){list.add(point); continue;}

            if(start.y > point.y){list.add(start); start = point; continue;}

            if(start.x < point.x){list.add(point); continue;}

            list.add(start); start = point;
        }

        list.sort((Point a, Point b)->{
            int ori = orientation(start, a, b);
            if(ori == 0){
                long adist = square(a.x - start.x) + square(a.y - start.y);
                long bdist = square(b.x - start.x) + square(b.y - start.y);
                if(adist > bdist) return -1;
                if(adist < bdist) return 1;
                return 0;
            }
            return ori;
        });

        removeDummy();

        int result = grahamScan();
        System.out.println(result);
    }
    static Point start;
    static ArrayList<Point> list = new ArrayList<Point>();

    static class Point{
        long x, y;
        Point(long x, long y){
            this.x = x; this.y = y;
        }
    }

    /**
     * a - b - c의 방향성이 반시계(-1), 일직선(0), 시계(1) 인지
     * @param a
     * @param b
     * @param c
     * @return
     */
    static int orientation(Point p, Point q, Point r){
        long val = (q.y - p.y)*(r.x - p.x)-(r.y - p.y)*(q.x - p.x);
        if(val < 0) return -1;
        if(val > 0) return 1;
        return 0;
    }

    static void removeDummy(){
        ArrayList<Point> cleaned = new ArrayList<Point>();
        for(int i = 0; i < list.size(); i++){
            Point now = list.get(i);
            cleaned.add(now);
            while(i+1 < list.size() &&orientation(start, now, list.get(i + 1)) == 0) i++;
        }
        list = cleaned;
    }

    static int grahamScan(){

        Iterator<Point> it = list.iterator();
        Stack<Point> stack = new Stack<Point>();
        stack.add(start);
        stack.add(it.next());
        stack.add(it.next());

        while(it.hasNext()){
            Point next = it.next();
            while(!stack.empty()){
                Point b = stack.pop();
                Point a = stack.peek();
                if(orientation(a, b, next) == -1){
                    stack.push(b);
                    break;
                }
            }
            stack.push(next);
        }

        return stack.size();
    }

    static Point fromSt(StringTokenizer st){
        return new Point(
            Long.parseLong(st.nextToken()),
            Long.parseLong(st.nextToken())
        );
    }

    static long square(long a){
        return a*a;
    }
}
