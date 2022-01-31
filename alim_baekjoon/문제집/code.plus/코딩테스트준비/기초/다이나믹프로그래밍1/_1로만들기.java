import java.util.*;

class _1로만들기 {
    
    /**
     * 예전에 푼 코드를 보니 피보나치 수열을 구성하듯 바텀업 방식으로 
     * N까지 구했었다.
     * 
     * 일반적인 방식으로 재귀함수를 구성하여 다이나믹 프로그래밍으로 구했지만
     * 최단경로 탐색등의 방법으로 풀 수 있지 않을까? 
     * 
     * ->> 주석처리 한 코드가 BFS로 푸는 코드
     */

    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        N = s.nextInt();

        System.out.println(solve(N));
        s.close();
    }

    static int N, MAX = 1000001;
    static int[] memo = new int[MAX];
    static{
        for(int i = 0; i < MAX; i++)    memo[i] = -1;
        memo[1] = 0;
    }

    static int solve(int n){
        if(n > N) return MAX;
        if(memo[n] != -1) return memo[n];

        memo[n] = MAX;
        if(n % 3 == 0) memo[n] = solve(n/3) + 1;
        if(n % 2 == 0) memo[n] = Math.min(memo[n] , solve(n/2) + 1);
        memo[n] = Math.min(memo[n], solve(n-1) + 1);

        return memo[n];
    }

    /*
     * BFS코드
     * 
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        LinkedList<Node> queue = new LinkedList<Node>();
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        boolean[] visited = new boolean[N+1];


        queue.add(new Node(N, 0));
        visited[N] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.n == 1){
                System.out.println(node.count);
            }

            if(node.n % 3 == 0) numbers.add(node.n / 3);
            if(node.n % 2 == 0) numbers.add(node.n / 2);
            numbers.add(node.n - 1);

            while(!numbers.isEmpty()){
                int n = numbers.poll();
                if(0 <= n && !visited[n]){
                    queue.add(new Node(n, node.count + 1));
                    visited[n] = true;
                }
            }
        }
        s.close();
    }
    

    static class Node{
        int n, count;
        public Node(int n, int count){this.n = n; this.count = count;}
    }
    */
     

    
}
