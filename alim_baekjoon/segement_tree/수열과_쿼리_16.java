import java.io.*;
import java.util.*;

public class 수열과_쿼리_16 {

    static int N, M;
    static int[] nums = new int[100001];
    static int[] tree = new int[400001];
    static{
        nums[0] = Integer.MAX_VALUE;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        initTree(1, N, 1);

        M = Integer.parseInt(br.readLine());
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 1){
                updateTree(1, N, 1, b, c);
                continue;
            }

            bw.write(getVal(1, N, 1, b, c)+"\n");
        }

        bw.flush();
        
    }

    static int initTree(int left, int right, int node){
        if(left > right) return 0;
        if(left == right) return tree[node] = left;
        int mid = (left + right) / 2;
        int a = initTree(left, mid, node*2);
        int b = initTree(mid + 1, right, node*2 + 1);
        if( nums[a] < nums[b] )
            tree[node] = a;
        else if(nums[a] == nums[b])
            tree[node] = Math.min(a, b);
        else
            tree[node] = b;
        return tree[node];
    }

    /**
     * 변경대상 범위가 아닌경우에 원래의 값을 반환해줘야한다.
     * @param left
     * @param right
     * @param node
     * @param p
     * @param val
     * @return
     */
    static int updateTree(int left, int right, int node, int p, int val){
        if(p < left || right < p) return tree[node];
        if(left == right){
            nums[left] = val;
            return tree[node] = left;
        }
        int mid = (left + right) / 2;
        int a = updateTree(left, mid, node*2, p, val);
        int b = updateTree(mid + 1, right, node*2 + 1, p, val);
        if(nums[a] < nums[b])
            tree[node] = a;
        else if(nums[a] == nums[b])
            tree[node] = Math.min(a, b);
        else
            tree[node] = b;

        return tree[node];
    }

    static int getVal(int left, int right, int node, int h, int t){
        if(h > right || t < left || left > right) return 0;
        if(h <= left && right <= t) return tree[node];
        int mid = (left + right) / 2;
        int a = getVal(left, mid, node*2, h, t);
        int b = getVal(mid + 1, right, node*2 + 1, h, t);

        if(nums[a] < nums[b]) return a;
        if(nums[a] == nums[b]) return Math.min(a, b);
        return b;
    }


}
