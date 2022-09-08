import java.io.*;
import java.util.*;

public class 구간_곱_구하기_11505 {

    /**
     * segement tree는 구간에 대한 참조가 있어야함.
     * 구간은 목적 데이터의 인덱스 데이터.
     */

    static int N, M, K;//수의 개수, 변경 횟수, 구간 곱 연산 횟수
    static long[] numbers = new long[1000001];
    static long[] tree = new long[4000004];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++)
            numbers[i] = Long.parseLong(br.readLine());

        fillTree(1, N, 1);

        for(int i = 0; i < (M + K); i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                updateTree(1, N, b, c, 1);
                continue;
            }
            bw.write(getVal(1, N, 1, b, c) + "\n");
        }

        bw.flush();
    }

    /**
     * numbers의 left~right를 이용해 node num의 노드를 루트로 하는 세그먼트 트리를 완성한다.
     * @param left
     * @param right
     * @param nodeNum
     * @return
     */
    static long fillTree(int left, int right, int nodeNum){
        if(left > right) return 1;
        if(left == right) return tree[nodeNum] = numbers[left];
        int mid = (left + right)/2;
        return tree[nodeNum] = ((fillTree(left, mid, nodeNum*2) * fillTree(mid+1, right, nodeNum*2 + 1)) % 1_000_000_007);
    }
    
    static long updateTree(int left, int right, int p, int val, int node){
        if(p < left || right < p) return tree[node];
        if(left == right){
            numbers[left] = val;
            return tree[node] = val;
        }
        int mid = (left + right) / 2;
        return tree[node] = ((updateTree(left, mid, p, val, node*2) * updateTree(mid+1, right, p, val, node*2 + 1)) % 1_000_000_007);
    }

    static long getVal(int left, int right, int node, int l, int r){
        if(r < left || right < l) return 1;
        if(l <= left && right <= r)
            return tree[node];
        
        int mid = (left + right) / 2;
        return (getVal(left, mid, node*2, l, r) * getVal(mid + 1, right, node*2 + 1, l, r)) % 1_000_000_007;
    }

}
