#include <iostream>
#include <utility>
#include <queue>

/**
 * @brief 
 * 길을 입력순서가 아니라 너비가 큰 순으로 재배치해서
 * 차례대로 길을 연결하는 중 특정 두 노드가 연결되면 답으로 간주하는 알고리즘 방식
 * 
 */

int root[1000];

int findRoot(int a){
    if(a == root[a]) return a;
    return root[a] = findRoot(root[a]);
}

void linkTwoPoint(int a, int b){
    a = findRoot(a);
    b = findRoot(b);
    if(a == b) return;
    if(a < b) root[a] = b;
    else root[b] = a; 
}

int main(){
    int p, w, c, v;//점 개수, 길 개수, 시작점, 도착점
    std::cin >> p >> w >> c >> v;

    for(int i = 0; i < p; i++) root[i] = i;//초기화

    int s, e, width;
    std::priority_queue< std::pair<int, std::pair<int, int>> > loads;
    while(w-- > 0){
        std::cin >> s >> e >> width;
        loads.push({width, {s, e}});
    }

    while(!loads.empty()){
        width = loads.top().first;
        s = loads.top().second.first;
        e = loads.top().second.second;
        loads.pop();
        linkTwoPoint(s, e);

        if(findRoot(c) == findRoot(v)){
            std::cout << width; break;
        }
    }
    return 0;
}