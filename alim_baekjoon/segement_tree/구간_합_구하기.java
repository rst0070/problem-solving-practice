import java.io.*;
import java.util.*;

public class 구간_합_구하기{

    static int N, O;
    static long[] tree = new long[4000001];
    static long[] arr = new long[1000001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        O = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++)
            arr[i] = Long.parseLong(br.readLine());

        makeTree(1, N, 1);

        while(O-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Long c = Long.parseLong(st.nextToken());

            if(a == 1){
                arr[b] = c;
                change(1, N, 1, b);
            }else{
                bw.write(getSum(1, N, b, c.intValue(), 1) + "\n");
            }
        }
        bw.flush();
    }

    static long makeTree(int head, int tail, int node){
        if(head > tail) return 0;
        if(head == tail)    return tree[node] = arr[head];

        int mid = (head + tail) / 2;
        return tree[node] = (makeTree(head, mid, node * 2) + makeTree(mid + 1, tail, node*2 + 1));
    }

    static long getSum(int head, int tail, int scopeS, int scopeE, int node){
        if(scopeE < head || scopeS > tail) return 0;
        if(scopeS <= head && tail <= scopeE) return tree[node];
        int mid = (head + tail) / 2;
        return getSum(head, mid, scopeS, scopeE, node*2) + getSum(mid + 1, tail, scopeS, scopeE, node*2 + 1);
    }

    static long change(int head, int tail, int node, int pos){
        if(pos < head || tail < pos) return tree[node];
        if(head == tail) return tree[node] = arr[head];
        int mid = (head + tail) / 2;
        return tree[node] = (change(head, mid, node * 2, pos) + change(mid + 1, tail, node*2 + 1, pos));
    }
}