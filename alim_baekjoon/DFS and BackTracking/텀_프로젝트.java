import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/9466
class Main{

    static int n;
    static int[] graph;
    static boolean[] checked;
    static boolean[] visited;
    static boolean[] inCycle;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0){
            n = Integer.parseInt(br.readLine());
            graph = new int[n+1];
            checked = new boolean[n+1];
            visited = new boolean[n+1];
            inCycle = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                graph[i] = Integer.parseInt(st.nextToken());
            }


        }
    }

    /**
     * 겹침이 발생한 지점을 반환한다.
     * 이 함수는 시작할때 visited[now] = true;
     * 끝날때 visited[now] = false;를 한다.
     * 재귀를 통해서 사이클이 발생하는 지점을 알 수 있을때
     * 이 지점을 visited로 조회해보면 자신보다 먼저 방문한곳이면 true,
     * 나중에 방문한 곳 이면 false가 된다.
     * 이를 통해서 자신이 사이클에 속한것 인지 알 수 있다.
     * 
     * 사이클이 겹친경우도 있을 수 있다..
     * 하지만 점 p를 방문했다면 p의 모든 가능한 사이클을 탐색했다는것.
     * 따라서 p를 두번 탐색할 필요는 없다.
     * 
     * 어떤 점 q의 사이클 가능성을 확인할 때,
     * 점 p가 q와 연결돼있고 이미 탐색한 경우일때, 
     * 1. p가 사이클에 속해 있다면, p는 다른점 하나만 가리킬 수 있으므로
     * 새로운 경로를 탐색하지 못하며, q는 이 사이클에 속하지 못한것이다.
     * 따라서 p를 새로 탐색할 필요가 없다.
     * 2. p가 사이클에 속해 있지 않다면, 1과같이 p는 다른점 하나만 가리킬 수 있으므로
     * 새로운 경로를 탐색하지 못한다. 즉 p는 사이클에 속하지 않았다는것이 확정된것.
     * 또한 q를 탐색하지 않은경우라면 p를 탐색했을때 q가 나오지 않는다는것이므로
     * p를 탐색할 필요가 없다.
     * 
     * 따라서 한번 탐색한 지점은 탐색할 필요가 없다.
     */
    static int findCycle(int now){
        if()
    }
}
