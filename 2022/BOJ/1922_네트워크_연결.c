#include <stdio.h>
#define INF 10000
int N, M;
int graph[1001][1001];
int selected[1001] = {0,};

int TOTAL_COST = 0;
void prim(){

    int cost[1001];
    for(int i = 1; i <= N; i++)
        cost[i] = INF;
    
    int now = 1; cost[now] = 0;
    for(int count = 1; count < N; count++){

        int min = INF;
        for(int i = 1; i <= N; i++)
            if(cost[i] < min && !selected[i])
                min = cost[i], now = i;
        selected[now] = 1;
        
        for(int next = 1;next <= N; next++)
            if(!selected[next] && graph[now][next] > 0 && cost[next] > graph[now][next])
                cost[next] = graph[now][next];
        
    }

    for(int i = 1; i <= N; i++)
        TOTAL_COST += cost[i];
}

int main(){
    scanf("%d", &N);
    scanf("%d", &M);
    for(int i = 0; i < M; i++){
        int a, b, c;
        scanf("%d %d %d", &a, &b, &c);
        graph[a][b] = c;
        graph[b][a] = c;
    }
    prim();
    printf("%d\n", TOTAL_COST);
    return 0;
}

// 1 3 4
// 3 2 2
// 2 4 7
// 4 5 3
// 5 6 8

// 1-3, 3-2, 3-4, 4-5, 4-6