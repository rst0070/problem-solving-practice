import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/9466
class Main{

    static int n;
    static int[] graph;
    static int[] checked;// 0:탐색하지않음, 1: 사이클 없음, 2: 사이클 있음
    static boolean[] visited;
    static boolean[] inCycle;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0){
            n = Integer.parseInt(br.readLine());
            graph = new int[n+1];
            checked = new int[n+1];
            visited = new boolean[n+1];
            inCycle = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                graph[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++){
                if(checked[i] == 0) findCycle(i);
            }

            int count = 0;
            for(int i = 1; i <= n; i++){
                if(checked[i] == 1) count++;
            }
            bw.write(count+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    /**
     * 겹침이 발생한 지점을 반환한다.
     * 이 함수는 시작할때 visited[now] = true;
     * 끝날때 visited[now] = false;를 한다.
     * 재귀를 통해서 사이클이 발생하는 지점을 알 수 있을것이다. 이를 점 p로 하면면
     * visited[p]의 의미가 중요하다는것을 알게된다.
     * visited[p] = true: p는 now보다 먼저 방문했다.
     * visited[p] = false: p는 now보다 나중에 방문되었다.
     * 왜냐하면 now의 다음점들을 방문하는 함수는 이미 작동이 끝났기때문.
     * 
     * 이를 통해서 사이클의 시작점이
     * now 혹은 now보다 먼저 방문된 점이라면,
     * now는 사이클에 속한것이다.
     * 
     * findCycle(p)를 진행하는 중에 p가 q를 가리킨다.
     * 이것의 의미는 p가 사이클에 속하기위해선 p와 q모두 사이클에 속해야한다는것.
     * 이는 이 문제의 조건을 변경하여 p가 여러개의 점을 가리켜도 성립한다.
     * (p가 a, b, c를 가릴킬때 각각 p, a || p, b || p, c 를 포함하는 사이클의 존재 여부를 찾는것)
     * 
     * 이때 이미 findCycle(q)가 실행된 상태라면?
     * q가 어떤 사이클에 속해있거나 사이클에 속하지 않아도
     * p는 그 사이클에 존재하지 않는다는 의미이다.
     * 따라서 q를 탐색할 필요가 없다.
     * 
     * 따라서 findCycle(q)를 실행했다면 q를 탐색했다는 것을 기록해야한다.
     * 이를 checked[q]에 기록하였다.
     * 
     */
    static int findCycle(int now){
        visited[now] = true;
        int next = graph[now];
        int result = 0;
        if(checked[next] == 0){
            if(visited[next]){
                checked[now] = 2;
                result = next;
            }else{
                result = findCycle(next);
                if( result != 0 && visited[result]) checked[now] = 2;
                else checked[now] = 1;
            }
        }else{
            checked[now] = 1;
        }
        visited[now] = false;
        return result;
    }
}
