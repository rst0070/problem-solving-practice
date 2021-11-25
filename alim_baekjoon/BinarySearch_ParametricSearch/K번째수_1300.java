import java.io.*;
//https://www.acmicpc.net/problem/1300
class Main{

    /**
     * k번째수는 k보다 작거나 같다.
     * K번째수와 같은 수가 여러개일때 어떻게 셀 것 인가?
     */

    static long N, K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        K = Long.parseLong(br.readLine());
        System.out.println(findNumber(1, K));
    }

    static long findNumber(long s, long e){
        if(s == e) return s;
        long mid = (s + e) / 2;
        long belowMid = calcul(mid); // number of numbers that belows mid and mid
        if(belowMid < K)  return findNumber(mid + 1, e); 
        return findNumber(s, mid);
    }
		//각 행의 a보다 작거나 같은 수를 센다.
    static long calcul(long a){//a와 같은 수의 개수까지 센다
        long result = 0;
        for(long i = 1; i <= N; i++){
            long v = Math.min(a/i, N);
            if(v == 0) break;
            result += v;
        }
        return result;
    }

}
