#include <iostream>
using namespace std;
int sX, sY, T, hX, hY, N;//성원, 시간, 집, 장애물 개수
bool stucks[401][401];
int Counting[401][401][201];
bool visited[401][401][201];
int find(int x, int y, int t){
    if(t < 0 || stucks[x][y]) return 0;
    if(visited[x][y][t])    return Counting[x][y][t];
    
    visited[x][y][t] = true;
    Counting[x][y][t] = find(x+1, y, t-1) + find(x, y+1, t-1) + find(x-1, y, t-1) + find(x, y-1, t-1);
    
    return Counting[x][y][t];
}
int main(){

    cin >> sX >> sY >> T >> hX >> hY >> N;
    hX = hX - sX + 200;
    hY = hY - sY + 200;
    for(int i=0; i <= T; i++){ Counting[hX][hY][i] = 1;    visited[hX][hY][i] = true;}

    int tmp1, tmp2;

    for(int i=0; i < N; i++){
        cin >> tmp1 >> tmp2;
        tmp1 = tmp1-sX+200;
        tmp2 = tmp1-sY+200;
        if(tmp1 >= 0 && tmp1 <= 400 && tmp2 >= 0 && tmp2 <= 400){ stucks[tmp1][tmp2] = true;}
    }

    cout << find(200, 200, T);

}