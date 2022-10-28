#include <iostream>
#include <algorithm>
#include <queue>
#include <limits.h>
using namespace std;
typedef struct Node{
    int num;
    long long pos;
}Node;
typedef struct Edge{
    int a, b;
    long long dis;
    bool operator<(const Edge e) const{
        return this->dis > e.dis;
    }
}Edge;

/* order: 각 좌표의 오름차순으로 노드 정보를 저장 x, y, z순*/
int N;
Node order[3][100000];

/* 각 좌표에 대해 노드 정렬시 사용 */
bool compareNode(Node a, Node b){return a.pos < b.pos;}

int parent[100000];
int find(int a){
    if(a == parent[a]) return a;
    return parent[a] = find(parent[a]);
}

void merge(int a, int b){
    a = find(a);
    b = find(b);
    if(a < b) parent[b] = a;
    else parent[a] = b;
}

int main(){
    //N == 1일때 처리 필요

    cin >> N;

    for(int i = 0; i < N; i++){
        parent[i] = i;
        for(int j = 0; j < 3; j++){
            order[j][i].num = i;
            cin >> order[j][i].pos;
        }
    }

    for(int i = 0; i < 3; i++)
        sort(order[i], order[i]+N, compareNode);

    priority_queue<Edge> queue;
    for(int i = 0; i < N-1; i++){
        for(int j = 0; j < 3; j++){
            Edge e;
            e.a = order[j][i].num;
            e.b = order[j][i+1].num;
            e.dis = order[j][i+1].pos - order[j][i].pos;
            queue.push(e);
        }
    }

    long long result = 0LL;
    Edge e;
    while(!queue.empty()){
        e = queue.top(); queue.pop();
        if(find(e.a) == find(e.b)) continue;
        merge(e.a, e.b);
        result += e.dis;
    }

    cout << result << '\n';
    return 0;
}