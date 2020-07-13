#include <iostream>
#include <stack>
using namespace std;
//참고: https://wellohorld.tistory.com/57
/**
 * (x, y)
 * (21, 20): 개미가 처음 움직이기 시작한 지점
 * (21, 21): 개미가 북쪽으로 한 번 움직.
 * 
 */
bool visit[44][44];//visit 배열
int n;
int dfs(int x, int y, int depth, int direction);
void initializeVisit(){
    for(int i=0; i< 44; i++)
        for(int j = 0; j < 44; j++)
            visit[i][j] = false;
    visit[21][20] = true;
}
int main(){
    initializeVisit();
    std::cin >> n;
    std::cout << dfs(21, 21, 0, 0);
}

/**
 * direction: dfs를 호출한 이전 노드의 위치 
 * 0: 수직 방향
 * 1: 왼쪽
 * 2: 오른쪽
 * 
 */
int dfs(int x, int y, int depth, int direction){
    if(depth == n){
        if(visit[x][y]) return 1;
        return 0;
    }

    if(x < 0 || y < 0 || x > 43 || y > 43 || visit[x][y]) return 0;

    int answer = 0;
    visit[x][y] = true;
    depth++;
    //바로 이전에 방문한 위치는 탐색하지 않아야한다.
    if(y%2 == 0){
        switch(direction){
            case 0:
            answer = dfs(x+1, y-1, depth, 1) + dfs(x-1, y-1, depth, 2);break;
            case 1:
            answer = dfs(x+1, y-1, depth, 1) + dfs(x, y+1, depth, 0);break;
            case 2:
            answer = dfs(x-1, y-1, depth, 2) + dfs(x, y+1, depth, 0);break;
        }
    }else{
        switch(direction){
            case 0:
            answer = dfs(x+1, y+1, depth, 1) + dfs(x-1, y+1, depth, 2);break;
            case 1:
            answer = dfs(x+1, y+1, depth, 1) + dfs(x, y-1, depth, 0);break;
            case 2:
            answer = dfs(x-1, y+1, depth, 2) + dfs(x, y-1, depth, 0);break;
        }
    }

    visit[x][y] = false;
    return answer;
}