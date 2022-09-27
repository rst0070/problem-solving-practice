#include <iostream>
int N, M, K;
int cost[10001];
int root[10001];

int findRoot(int a){
    if(root[a] == a) return a;
    return root[a] = findRoot(root[a]);
}

void merge(int a, int b){
    a = findRoot(a); b = findRoot(b);
    if(a == b) return;
    if(cost[a] <= cost[b]){
        root[b] = a;
    }else{
        root[a] = b;
    }
}

int main(){
    int a, b, result = 0;
    std::cin >> N >> M >> K;
    for(int i = 1; i <= N; i++){
        std::cin >> cost[i];
        root[i] = i;
    }

    while(M-- > 0){
        std::cin >> a >> b;
        merge(a, b);
    }

    for(int i = 1; i <= N; i++){
        if(root[i] == i) result += cost[i];
    }

    if(result > K)
        std::cout << "Oh no" << std::endl;
    else
        std::cout << result << std::endl;
}