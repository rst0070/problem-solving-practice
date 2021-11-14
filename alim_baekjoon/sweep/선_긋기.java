import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2170
class Main{

    /**
     * 선을 시작점으로 정렬시켜 처음부터 돌면서 오버랩된 부분포함해 길이 계산
		 */
    static class Line implements Comparable<Line>{
        int start, end;
        public Line(int s, int e){
            super();
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Line l){
            if(this.start < l.start) return -1;
            if(this.start == l.start) return 0;
            return 1;
        }
    }

    static int N;
    static Line[] lines;
    public static void main(String[] args) throws Exception{
        int s, e;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lines = new Line[N];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            lines[i] = new Line(s, e);
        }
        br.close();

        Arrays.sort(lines);
        s = lines[0].start;
        e = lines[0].end;

        int length = 0;
        for(int i = 1; i < N; i++){
            if(s <= lines[i].start && lines[i].start <= e){
                if(e < lines[i].end){ e = lines[i].end;}
            }else{
                length += e - s;
                s = lines[i].start;
                e = lines[i].end;
            }
        }
        length += e - s;
        System.out.println(length);
    }

}
