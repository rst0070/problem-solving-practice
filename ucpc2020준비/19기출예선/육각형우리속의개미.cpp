/**
 * 문제: https://www.acmicpc.net/problem/17370
 * 참고: https://wellohorld.tistory.com/57
 * 
 * 이 문제는 dfs를 이용한 사이클을 찾는 문제이다.
 * 어려운 점은 육각형 우리를 그래프로 표현하는 방법!
 * 
 * 여러 방법으로 연결관계를 표현할 수 있겠지만, 나는 육각형을 그대로 사용했다.
 *  . . .
 *   / \
 *  . . .
 *  |   |
 *  . . .
 *   \ /
 *  . . .
 * 
 * 위의 그림과 같이 .을 2차원 좌표계의 x, y값이 정수인 정점, 짝대기를 개미가 이동할 수 있는 경로로 표현할 수 있다.
 * 따라서 2차원 배열로 육각형 모양 우리를 표현 할 수 있다.
 * 
 * 문제의 제시조건을 살펴보면
 * 1. 개미가 어떤 방향으로 움직이든 처음의 움직임은 북쪽으로 이동한다고 여긴다.
 * 2. 이동횟수는 최대 22번이다.
 * 3. 개미의 이동방향은 2가지이다. 즉, 왔던길로 다시 되돌아가지 않는다.
 * 
 * 이를 통해서 시작 좌표를 설정 할 수 있다.
 * (x, y)
 * (21, 20): 개미가 처음 움직이기 시작한 지점
 * (21, 21): 개미가 북쪽으로 한 번 움직였을때 위치
 * 
 * 시작점의 y값이 짝수 이므로
 * y가 짝수인곳에서는 위로 이동하거나, 양쪽 아래로 이동가능.
 * y가 홀수인곳에서는 아래로 이동하거나, 양쪽 위로 이동가능하다.
 * 
 * 위 방식을 이용하여 재귀적으로 dfs를 구현하고, 
 * 바로 직전의 위치로 되돌아가지 않도록 파라미터를 통해 직전의 위치를 저장할 수 있다.
 */

#include <iostream>
#include <stack>
using namespace std;

bool visit[44][44];//visit 배열

int n;
int dfs(int x, int y, int depth, int direction);

int main(){
    //initialize visit array: 모든 원소는 0으로 초기화된다.
    visit[21][20] = true;

    std::cin >> n;
    std::cout << dfs(21, 21, 0, 0);// 북쪽으로 한번 움직인다.
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
    //direction prameter를 통해 직전에 방문한 위치를 저장한다.
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