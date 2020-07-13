#include <iostream>

int N, K;
long data[201][201];//data[i][j]: i를 j개로 나누는 가짓수;

int topDown(int n, int k){//가짓수 반환
    if(n < 0 || k < 1) return 0;
    if(data[n][k] > 0) return data[n][k];

    if(k==1) data[n][k] = 1;
    else{
        for(int i = n; i > -1; i--){
            data[n][k] += topDown(n-i, k-1);
            if(data[n][k] >= 1000000000) data[n][k] = data[n][k]%1000000000;
        }

    }

    return data[n][k];
}

int main(){
    std::cin >> N >> K;
    std::cout << topDown(N, K);
}