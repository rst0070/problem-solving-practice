import java.io.*;
import java.util.*;

public class 연산자_끼워넣기 {
    
    static final int MAX = 1000000000;
    static int N;//N
    static int[] sign = new int[4];//더하기, 빼기, 곱하기, 나누기 개수
    static int[] sequence;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++)  sign[i] = Integer.parseInt(st.nextToken());

        Result result = solve(sequence[0], 0, sign[0], sign[1], sign[2], sign[3]);

        System.out.println(result.max);
        System.out.println(result.min);
    }

    /**
     * 
     * @param prev 이전 계산 결과
     * @param point 현재 선택해야하는 연산자(0<= point <= n-2)
     * @param a, b, c, b - 각 연산 가능횟수
     */
    static Result solve(int prev, int point, int a, int b, int c, int d){

        if(point > (N - 2)){
            return new Result(prev, prev);
        }

        Result result = new Result();

        if(a > 0){
            result = solve(prev + sequence[point + 1], point + 1, a - 1, b, c, d);
        }

        if(b > 0){
            result.compare( solve(prev - sequence[point + 1], point + 1, a, b - 1, c, d) );
        }

        if(c > 0){
            result.compare( solve(prev * sequence[point + 1], point + 1, a, b, c - 1, d) );
        }

        if(d > 0){
            result.compare( solve(prev / sequence[point + 1], point + 1, a, b, c, d - 1) );
        }

        return result;
    }

    static class Result {
        int max, min;
        public Result(){ this.max = -1 * MAX; this.min = MAX;}
        public Result(int max, int min){ this.max = max; this.min = min;}

        public void compare(Result r){
            if(r.max > this.max) this.max = r.max;
            if(r.min < this.min) this.min = r.min;
        }
    }
}
