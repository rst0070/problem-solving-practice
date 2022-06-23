import java.io.*;
import java.util.*;

public class xor {
    static int N, M;
    static int[] arr = new int[500001];
    static int[] tree = new int[2000004];
    static int[] lazy = new int[2000004];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
        initTree(1, 1, N);

        M = Integer.parseInt(br.readLine());

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken()) + 1;
            int j = Integer.parseInt(st.nextToken()) + 1;

            if(type == 1){
                int val = Integer.parseInt(st.nextToken());
                updateTree(1, 1, N, val, i, j);
            }else{
                int val = getVal(1, 1, N, i, j);
                bw.write(val + "\n");
            }
        }

        bw.flush();
    }

    static int initTree(int index, int left, int right){
        if(left > right) return 0;
        if(left == right) return tree[index] = arr[left];
        int mid = (left + right) / 2;
        return tree[index] = (initTree(index*2, left, mid) ^ initTree(index*2 + 1, mid + 1, right));
    }

    static int getVal(int index, int left, int right, int start, int end){
        if(left > right) return 0;//노드가 아닌경우 xor값에 영향을 주지않는 0반환
        updateLazyProp(index, left, right);
        if(end < left || right < start) return 0;
        if(start <= left && right <= end){
            return tree[index];
        }
        int mid = (left + right) / 2;
        return getVal(index*2, left, mid, start, end) ^ getVal(index*2 + 1, mid + 1, right, start, end);
    }

    static int updateTree(int index, int left, int right, int val, int start, int end){
        if(left > right) return 0;
        updateLazyProp(index, left, right);
        if(end < left || right < start) return tree[index];//변경 대상이 아닌경우 원래값 반환
        if(start <= left && right <= end){//변경 대상이면 lazy값을 갱신하고 반영
            lazy[index] ^= val;
            updateLazyProp(index, left, right);
            return tree[index];
        }
        int mid = (left + right) / 2;
        return tree[index] = (updateTree(index*2, left, mid, val, start, end) ^ updateTree((index*2) + 1, mid + 1, right, val, start, end));
    }

    static void updateLazyProp(int index, int left, int right){
        if(lazy[index] == 0) return;

        if((right - left + 1) % 2 == 1)
            tree[index] ^= lazy[index];
        
        if(left != right){
            lazy[index * 2] ^= lazy[index];
            lazy[(index * 2) + 1] ^= lazy[index];
        }

        lazy[index] = 0;
    }
}
