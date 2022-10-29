/**
 * https://www.acmicpc.net/problem/23034
 * N명의 학생, M개의 회선(학생 - 학생 연결)이 있다.
 * N명의 학생을 2개의 조로 편성하고 
 * 각팀의 한명에게만 정보를 전달해 전체에게 전달하고 싶음.
 * 전달할 두명 X, Y를 정할때 비용이 얼마가 드는가?
 * 각 회선의 비용이 있다.
 * 
 * 그냥 Q번 모두 탐색을 한다면, kruskal algorithm을 실행하고 Q*M번 edge를 test한다. -> 시간초과
 * 모든 학생에 대해 MST를 만들어 놓고 가장 비용이 큰 line을 끊는다 -> 각각의 최적은 모르겠으나 전체의 비용 최적화
 * 
 * MST를 한번 만들고 이를 두개의 트리로 나눈다면, 이 두 트리의 가중치의 합이 각각을 최소의 가중치로 만든 트리 일때와 같을까?
 * -> 맞다....
 */
#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

struct Edge{
    int a, b, cost;
    bool operator<(const struct Edge e)const{
        return this->cost < e.cost;
    }
}edges[100001];

typedef struct edge{
    int to, cost;
}edge;

int N, M, T = 0;

int parent[1001];
int find(int a){
    if(parent[a] == a) return parent[a] = a;
    return parent[a] = find(parent[a]);
}

vector<edge> adj[1001];
int big_cost[1001][1001] = {0};
int vis[1001] = {0};

void dfs(int from, int now, int cost){
    for(edge e : adj[now])
        if(!vis[ e.to ]){
            vis[e.to] = true;
            big_cost[from][e.to] = max(cost, e.cost);
            dfs(from, e.to, big_cost[from][e.to]);
        }
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin >> N >> M;

    for(int i = 1; i <= N; i++) parent[i] = i;

    for(int i = 0; i < M; i++){
        cin >> edges[i].a >> edges[i].b >> edges[i].cost;
    }
    
    sort(edges, edges+M);

    for(int i = 0; i < M; i++){
        struct Edge* now = &(edges[i]);
        int fa = find(now->a);
        int fb = find(now->b);
        if(fa == fb) continue;

        parent[fa] = fb;

        T += edges[i].cost;
        adj[now->a].push_back({now->b, now->cost});
        adj[now->b].push_back({now->a, now->cost});
    }

    for(int i = 1; i <= N; i++){
        vis[i] = 1;
        dfs(i, i, 0);
        memset(vis, 0, sizeof(vis));
    }

    int a, b, q;
    cin >> q;
    while(q-- > 0){
        cin >> a >> b;
        cout << T - big_cost[a][b] << '\n';
    } 

    
    return 0;
}