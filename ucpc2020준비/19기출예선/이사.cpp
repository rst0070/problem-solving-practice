/**
 * 문제: https://www.acmicpc.net/problem/17371
 * 
 * 이 문제를 풀기위해 알아야하는 가장 중요한 사실은 집의 좌표가 편의시설의 좌표와 같아도 상관없다는 것 이다.
 * 
 * 따라서 편의시설 A와 가장 멀리 떨어진 편의시설 B를 찾은 다음에 이를 기록한다.
 * 이를 n번 반복하면 모든 (A, B) 쌍 중에 어떤 것이 가장 짧은 거리를 갖는지 알게 된다.
 * 그에 해당하는 A의 좌표를 출력하면 된다.
 * 
 */
#include <iostream>
int n;
int data[1000][2];
int main(){
    std::cin >> n;
    for(int i = 0; i < n; i++){
        std::cin >> data[i][0] >> data[i][1];//좌표저장하기
    }

    int length = 2147483647, j;
    int answer;
    int a, b;
    for(int i=0; i < n; i++){
        //각각의 A에 맞는 B찾기
        int max = 0;
        for(j=0; j < n; j++){
            if(i==j)continue;
            a = data[j][0] - data[i][0];
            b = data[j][1] - data[i][1];
            max = (a = a*a + b*b)>max ? a : max;
        }
        if(max < length){//지금까지 기록중에 가장 짧은 거리라면 현재의 A를 정답 후보로 저장
            length = max;
            answer = i;
        }
    }

    std::cout << data[answer][0] << " " << data[answer][1] << std::endl;
}