import java.io.*;
import java.util.*;

public class ThinkingHeap {

    /**
     * 어떠한 논리로?
     * 일단 가능한지 불가능한지 판단
     * K >= depth(P) (둘다 1부터 시작)
     * && sub(P) <= N - K
     * 
     * 이 조건을 만족하면 그냥 대입하면 됨.
     */


    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if(K >= getDepth(P) && (numOfNode(P) - 1 <= N - K)){
            fillTree();
            for(int i = 1; i <= N; i++) bw.write(arr[i] + "\n");         
        }else{
            bw.write("-1\n");
        }
        bw.flush();bw.close();
    }    

    static int N, K, P;
    static int[] arr;//arr[i] : i위치에 있는 트리의 노드의 값
    static boolean[] filled = new boolean[200001];//filled[i] : i라는 숫자를 트리 노드의 값으로 사용했다.
    static int numOfNode(int root){
        if(root > N) return 0;
        return 1 + numOfNode(root * 2) + numOfNode((root * 2) + 1);
    }

    //root의 깊이가 1일때 nodeP(위치값)의 깊이
    static int getDepth(int nodeP){
        int result = 1;
        while(nodeP > 1){
            nodeP = nodeP / 2;
            result++;
        }
        return result;
    }

    //arr(트리)에 숫자를 채운다
    static void fillTree(){
        //K채우기
        arr[P] = K;
        filled[K] = true;

        //P번째 노드의 부모들 값 채우기
        int tmp = getDepth(P) - 1;
        for(int p = P/2; p >= 1; p = p / 2){
            filled[tmp] = true;
            arr[p] = tmp--;
        }

        //P번째 노드의 자식들 값 채우기
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(P*2); queue.add(P*2 + 1);
        tmp = K + 1;
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now > N){break;}

            filled[tmp] = true;
            arr[now] = tmp++;
            queue.add(now * 2);
            queue.add(now * 2 + 1);
        }

        //나머지 값 채우기(안쓴것들중)
        tmp = 1;
        for(int i = 1; i <= N; i++){
            if(arr[i] != 0) continue;
            while(filled[tmp]) tmp++;
            arr[i] = tmp;
            filled[tmp] = true;
        }
    }
}
