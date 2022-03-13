import java.io.*;
import java.util.*;

public class 히스토그램1725 {

    /**
     * https://www.acmicpc.net/problem/1725
     * 
     * 큰 막대 부터 시작
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        histogram = new long[N];
        for(int i = 0; i < N; i++)  histogram[i] = Integer.parseInt(br.readLine());
        System.out.println(find(0, N - 1));
    }
    static long[] histogram;
    static long find(int start, int end){
        if(start == end) return histogram[start];
        int mid = (start + end) / 2;

        long result = find(start, mid);
        result = Math.max(result, find(mid + 1, end));

        if(histogram[mid] < histogram[mid + 1]) mid++;
        int s = mid; int e = mid;
        long min = histogram[mid];
        while(s >= start && e <= end){
            result = Math.max(result, min * (e - s + 1));
            if(e == end && s == start) break;
            if(e == end){s--; min = Math.min(min, histogram[s]);continue;}
            if(s == start){e++; min = Math.min(min, histogram[e]);continue;}

            if(histogram[s - 1] < histogram[e + 1]){e++; min = Math.min(min, histogram[e]);}
            else{s--; min = Math.min(min, histogram[s]);}
        }
        return result;
    }
}