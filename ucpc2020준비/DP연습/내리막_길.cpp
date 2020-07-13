#include <iostream>
int M, N;
int map[500][500];
int memo[500][500];

int topDown(int m, int n, int prev){
    if(m < 0 || n < 0 || m >= M || n >= N || prev <= map[m][n]) return 0;
    if(memo[m][n] > -1) return memo[m][n];

    memo[m][n] = 
    topDown(m-1, n, map[m][n]) + topDown(m+1, n, map[m][n]) +
    topDown(m, n-1, map[m][n]) + topDown(m, n+1, map[m][n]);
    return memo[m][n];
}
int main(){
    std::cin >> M >> N;
    int i, j;
    for(i = 0; i < M; i++)
        for(j = 0; j < N; j++){
            std::cin >> map[i][j];
            memo[i][j] = -1; 
        }
    memo[M-1][N-1] = 1;      
    std::cout << topDown(0, 0, map[0][0]+1);
}