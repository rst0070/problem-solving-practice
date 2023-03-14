import java.io.*;
import java.util.*;

/**
 * 세그먼트 트리 이용한 풀이
 */
public class 최솟값_10868 {
    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        
        for(int i = 1; i <= N; i++)
            nodes[i] = Integer.parseInt(br.readLine());
        makeTree(1, N, 1);

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(find(1, N, start, end, 1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static int MAX = 1000000000;
    static int[] nodes = new int[500001];
    static int[] tree = new int[500001];

    static int makeTree(int head, int tail, int node){
        if(head > tail) return MAX;
        if(head == tail) return (tree[node] = nodes[head]);
        int mid = (head + tail) >> 1;
        return tree[node] = Math.min(
            makeTree(head, mid, node * 2),
            makeTree(mid + 1, tail, node * 2 + 1)
        );
    }

    static int find(int head, int tail, int ss, int se, int node){
        if(head > tail || ss > tail || se < head) return MAX;
        if(ss <= head && tail <= se) return tree[node];
        int mid = (head + tail) >> 1;
        return Math.min(
            find(head, mid, ss, se, node*2),
            find(mid+1, tail, ss, se, node*2 + 1)
        );
    }
}
