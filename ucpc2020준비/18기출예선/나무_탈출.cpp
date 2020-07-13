#include <iostream>
#include <queue>
using namespace std;
int N, answer = 0;
queue<int> graph[500001];
bool visited[500001];

void dfs(int now, bool digit){
    int tmp;
    bool thisIsLeef = true;
    while(!graph[now].empty()){
        tmp = graph[now].front(); graph[now].pop();
        if(visited[tmp]) continue;
        thisIsLeef = false;
        visited[tmp] = true;
        dfs(tmp, !digit);
    }

    if(thisIsLeef) answer += digit;
}

int main(){
    cin >> N;

    int a, b;
    //int answer = 0;
    for(int i=1; i < N; i++){
        cin >> a >> b;
        graph[a].push(b);
        graph[b].push(a);
    }
    visited[1] = true;
    dfs(1, 0);

    //cout << answer << endl;
    if(answer%2 == 0) cout << "No";
    else cout << "Yes";
}