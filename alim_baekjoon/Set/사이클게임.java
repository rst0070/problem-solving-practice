import java.io.*;
import java.util.*;

public class 사이클게임 {
    static int[] parent = new int[500000];
    static{
        for(int i = 0; i < 500000; i++) parent[i] = i;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        int M = Integer.parseInt(st.nextToken());

        int result = 0;
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!drawLine(a, b)){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    static int find(int a){
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
    static boolean drawLine(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        parent[a] = b;
        return true;
    }
}
