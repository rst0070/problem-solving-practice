#include <iostream>

/** 자신의 root로 부터 얼만큼 무거운지 나타낸다. */
int W[100001];

int root[100001];

void initData(int n){
    for(int i = 1; i <= n; i++){
        W[i] = 0;
        root[i] = i;
    }
}

int findRoot(int node){
    if(node == root[node]) return node;

    int r = findRoot(root[node]);
    W[node] += W[root[node]];

    return root[node] = r;
}

/**
 * @brief 
 * a - a_root_w = W[a]
 * b - b_root_w = W[b]
 * b - a = weight
 * b - a + a_root_w - b_root_w = W[b] - W[a]
 * a_root_w - b_root_w = W[b] - W[a] - weight
 * b_root_w - a_root_w = W[a] - W[b] + weight
 * 위 관계를 이용해 a와 b의 루트들을 연결한다.
 * 이때 샘플번호가 작은것이 루트가 된다.
 * @param a 
 * @param b 
 * @param weight - a보다 b가 얼마나 무거운지
 */
void mergeW(int a, int b, int weight){
    int root_a = findRoot(a);
    int root_b = findRoot(b);

    if(root_a == root_b) return;

    if(root_a < root_b){
        root[root_b] = root_a;
        W[root_b] = W[a] - W[b] + weight;
    }else{
        root[root_a] = root_b;
        W[root_a] = W[b] - W[a] - weight;
    }
}

int main(){
    std::ios_base::sync_with_stdio(false); std::cin.tie(NULL);

    int n, m, a, b, c, d;
    char order;

    std::cin >> n >> m;
    while(n != 0 || m != 0){

        initData(n);

        while(m-- > 0){
            std::cin >> order;
            if(order == '!'){
                std::cin >> a >> b >> c;
                mergeW(a, b, c);
            }else{
                std::cin >> a >> b;
                if(findRoot(a) == findRoot(b)){//무게 차이 찾을 수 있을때.
                    std::cout << W[b] - W[a] << '\n';
                }else{
                    std::cout << "UNKNOWN\n";
                }
            }
        }

        std::cin >> n >> m;
    }
}
