import java.io.*;
import java.util.*;

public class 가장_긴_증가하는_부분_수열5 {

    //https://seungkwan.tistory.com/8

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1]; LIS = new int[N + 1]; P = new int[N + 1];
        Arrays.fill(LIS, INF);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)  arr[i] = Integer.parseInt(st.nextToken());

        int length = find(1, 1);
        System.out.println(length);

        Stack<Integer> result = new Stack<Integer>();
        for(int i = N; i > 0; i--){
            if(length == 0) break;
            if(P[i] == length){result.push(arr[i]); length--;}
        }

        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty())    sb.append(result.pop() + " ");
        System.out.println(sb);
    }
    static int N;
    static int[] arr;
    static int[] LIS;
    static int[] P;
    static final int INF = 1000000001;

    static int find(int p, int length){
        if(p > N) return length;

        if(LIS[length] < arr[p]){
            length++;
            LIS[length] = arr[p];
            P[p] = length;
            
            return find(p + 1, length);
        }

        if(LIS[length] == arr[p]){
            P[p] = length;
            
            return find(p + 1, length);
        }

        int position = lowerBound(1, length, arr[p]);
        LIS[position] = arr[p];
        P[p] = position;
        return find(p + 1, length);
    }

    //https://sangwoo0727.github.io/algorithm/Algorithm-Ublb/#:~:text=Lower%20Bound%EB%8A%94%20%EB%8D%B0%EC%9D%B4%ED%84%B0%20%EB%82%B4,%EB%A5%BC%20%EB%A6%AC%ED%84%B4%ED%95%B4%EC%A3%BC%EB%8A%94%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9D%B4%EB%8B%A4.&text=%EC%A4%91%EB%B3%B5%EB%90%98%EB%8A%94%20%EC%9B%90%EC%86%8C%EA%B0%80%20%EC%97%AC%EB%9F%AC%EA%B0%9C,%EB%A5%BC%20%EC%B0%BE%EA%B8%B0%20%EC%9C%84%ED%95%B4%20%EC%82%AC%EC%9A%A9%ED%95%9C%EB%8B%A4.
    static int lowerBound(int head, int tail, int num){
        int mid;
        while(head < tail){
            mid = (head + tail) / 2;
            if(LIS[mid] < num) head = mid + 1;
            else tail = mid;
        }
        return tail;
    }
}
