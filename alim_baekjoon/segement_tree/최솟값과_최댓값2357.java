import java.io.*;
import java.util.*;

public class 최솟값과_최댓값2357 {

    static int[] nums = new int[100001];
    static int[] maxTree = new int[400004];
    static int[] minTree = new int[400004];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) nums[i] = Integer.parseInt(br.readLine());

        createMin(1, 1, N);
        createMax(1, 1, N);

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int min = findMin(1, 1, N, start, end);
            int max = findMax(1, 1, N, start, end);
            bw.write(min + " " + max + "\n");
        }
        bw.flush();
    }

    static int createMin(int index, int head, int tail){
        if(head > tail) return 1000000000;
        if(head == tail) return minTree[index] = nums[head];
        int mid = (head + tail) >> 1;
        return minTree[index] = Integer.min(createMin(index*2, head, mid), createMin(index*2 + 1, mid + 1, tail));
    }

    static int createMax(int index, int head, int tail){
        if(head > tail) return 1;
        if(head == tail) return maxTree[index] = nums[head];
        int mid = (head + tail) >> 1;
        return maxTree[index] = Integer.max(createMax(index*2, head, mid), createMax(index*2 + 1, mid + 1, tail));
    }

    static int findMax(int index, int head, int tail, int ss, int se){
        if(head > tail || tail < ss || se < head) return 1;
        if(ss <= head && tail <= se) return maxTree[index];
        int mid = (head + tail) >> 1;
        return Integer.max(
            findMax(index*2, head, mid, ss, se), 
            findMax(index*2 + 1, mid + 1, tail, ss, se)
        );
    }

    static int findMin(int index, int head, int tail, int ss, int se){
        if(head > tail || tail < ss || se < head) return 1000000000;
        if(ss <= head && tail <= se) return minTree[index];
        int mid = (head + tail) >> 1;
        return Integer.min(
            findMin(index*2, head, mid, ss, se),
            findMin(index*2 + 1, mid + 1, tail, ss, se)
        );
    }
}
