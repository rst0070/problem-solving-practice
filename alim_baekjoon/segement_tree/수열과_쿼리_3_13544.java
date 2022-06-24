import java.io.*;
import java.util.*;

public class 수열과_쿼리_3_13544 {
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[4*N + 4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            initTree(1, 1, N, i, num);
        }
        sortTree(1, 1, N);

        int M = Integer.parseInt(br.readLine());
        int lastAns = 0;
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) ^ lastAns;
            int j = Integer.parseInt(st.nextToken()) ^ lastAns;
            int k = Integer.parseInt(st.nextToken()) ^ lastAns;
            lastAns = query(1, 1, N, i, j, k);
            bw.write(lastAns + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static void initTree(int idx, int left, int right, int pos, int num){
        if(left > right || pos < left || right < pos) return;
        if(tree[idx] == null) tree[idx] = new ArrayList<Integer>(right - left + 1);
        tree[idx].add(num);
        if(left == right) return;
        int mid = (left + right) / 2;
        initTree(idx*2, left, mid, pos, num);
        initTree(idx*2 + 1, mid + 1, right, pos, num);
    }

    static void sortTree(int idx, int left, int right){
        if(left >= right) return;
        Collections.sort(tree[idx]);
        int mid = (left + right) / 2;
        sortTree(idx*2, left, mid);
        sortTree(idx*2 + 1, mid + 1, right);
    }

    static int query(int idx, int l, int r, int s, int e, int k){
        if(l > r || e < l || r < s) return 0;
        if(s <= l && r <= e){
            int h = 0;
            int t = r - l;
            int result = 0;
            while(h <= t){
                int mid = (h + t) / 2;
                if(tree[idx].get(mid) <= k){
                    h = mid + 1;
                }else{
                    t = mid - 1;
                    result = tree[idx].size() - mid;
                }
            }
            return result;
        }

        int mid = (l + r) / 2;
        return query(idx*2, l, mid, s, e, k) + query(idx*2 + 1, mid + 1, r, s, e, k);
    }
}
