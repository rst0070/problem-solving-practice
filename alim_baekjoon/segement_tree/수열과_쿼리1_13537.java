import java.io.*;
import java.util.*;

public class 수열과_쿼리1_13537 {

    static ArrayList<Integer>[] tree;

    /**
     * 구간 노드가 해당 구간의 정렬된 값을 가지고 있으면 된다.
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[4*N + 4];
        initTreeSize(1, 1, N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            fillTree(1, 1, N, i, num);
        }
        sortTree(1, 1, N);

        int M = Integer.parseInt(br.readLine());
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String result = query(1, 1, N, i, j, k) + "\n";
            bw.write(result);
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void initTreeSize(int index, int left, int right){
        if(left > right) return;
        tree[index] = new ArrayList<Integer>(right - left + 1);
        int mid = (left + right) / 2;
        if(left == right) return;
        initTreeSize(index*2, left, mid);
        initTreeSize(index*2 + 1, mid + 1, right);
    }

    static void fillTree(int index, int left, int right, int pos, int val){
        if(left > right || pos < left || right < pos) return;
        tree[index].add(val);
        if(left == right) return;

        int mid = (left + right) / 2;
        fillTree(index*2, left, mid, pos, val);
        fillTree(index*2 + 1, mid + 1, right, pos, val);
    }

    static void sortTree(int index, int left, int right){
        if(left >= right) return;
        Collections.sort(tree[index]);
        int mid = (left + right) / 2;
        sortTree(index*2, left, mid);
        sortTree(index*2 + 1, mid + 1, right);
    }

    static int query(int index, int left, int right, int ss, int se, int k){
        if(left > right || se < left || right < ss) return 0;
        if(ss <= left && right <= se){
            int head = 0;
            int tail = tree[index].size() - 1;
            int result = 0;
            while(head <= tail){
                int mid = (head + tail) / 2;
                if( tree[index].get(mid) <= k ){
                    head = mid + 1;
                }else{
                    tail = mid - 1;
                    result = tree[index].size() - mid;
                }
            }
            return result;
        }

        int mid = (left + right) / 2;
        return query(index*2, left, mid, ss, se, k) + query(index*2 + 1, mid + 1, right, ss, se, k);
    }
}
