#include <iostream>
#include <stdlib.h>
//using namespace std;
int N, K, P, NUM;
int array[200001];
bool visited[200001];

void countChilds(int i, int * count){
    if(i > N) return;
    if(NUM <= K){
        std::cout << -1;
        exit(0);
    }
    visited[NUM] = true;
    array[i] = NUM--;
    *count++;

    countChilds(2*i, count);
    countChilds(2*i + 1, count);
}
int main(){
    std::cin >> N >> K >> P;

    int n_parents = 0, n_childs = 0, i = P, tmp = K;
    array[i] = K;
    visited[tmp] = true;
    while(i > 1){
        visited[tmp] = true;
        array[i] = tmp--;
        n_parents++;   i = i/2;
    }
    if(n_parents >= K){
        std::cout << -1;
        exit(0);
    }
    NUM = N;
    countChilds(2*P, &n_childs);
    countChilds(2*P + 1, &n_childs);
        
    tmp = 0;
    for(i = 1; i <= N; i++){

        if(array[i]>0){
            std::cout << array[i] << std::endl;
        }else{
            while(++tmp <=N && visited[tmp]);
            if(tmp<=N){ std::cout << tmp << std::endl; visited[tmp] = true; }
        }
    }
    

}