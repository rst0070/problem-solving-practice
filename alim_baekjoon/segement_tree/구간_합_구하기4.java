import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11659
class Main{

    /**
     * 세그먼트 트리의 필요성?
     * 
     * https://yabmoons.tistory.com/431
     * 
     */


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        tree = new int[3*N];
        segement = new int[3*N + 2][2];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)  arr[i] = Integer.parseInt(st.nextToken());

        makeTree(1, 1, N);
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(find(1, start, end)+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static int[] arr;
    static int[] tree;
    static int[][] segement;
    static int makeTree(int node, int head, int tail){
        segement[node][0] = head;
        segement[node][1] = tail;
        if(head == tail) return tree[node] = arr[head];
        int mid = (head + tail) / 2;
        int left = makeTree(node * 2, head, mid);
        int right = makeTree(node*2 + 1, mid + 1, tail);
        return tree[node] = left + right;
    }

    static int find(int node, int start, int end){
        if(end < segement[node][0] || segement[node][1] < start) return 0;
        if( start <= segement[node][0] && segement[node][1] <= end ) return tree[node];

        int left = find(node*2, start, end);
        int right = find(node*2 + 1, start, end);
        return left + right;
    }

}
