/**
 * @file 1655_가운데를_말해요.cpp
 * @version 0.1
 * @date 2022-11-24
 * 
 * 각 시점의 중간값을 구해야한다.
 * O(NlogN) 정도가 필요
 * 즉 각 입력이 들어올때 마다 logN의 연산을 하면됨
 * 
 * 우선순위큐 2개를 아용한다.??
 * 가운데를 가리키도록 만든다. --> 와 이런 아이디어를.....
 * 즉 정렬을 한다면 1 2 3 4 5 6 7 8
 * 이렇게 있으면 최댓값을 출력하도록하는 우선순위큐는 1 2 3 4
 * 
 * 최솟값을 출력하도록하는 우선순위큐는 5 6 7 8을 갖도록 저장하는것
 * 
 * 1. 두개 큐의 사이즈가 같도록 입력값을 저장한다.
 * 2. 새로운 값이 들어왔으므로 해당 값으로 인해 두개 큐의 대소관계가 맞는지 확인하고
 * 아니면 swap한다.
 * 
 * !! 새로 알게된점.
 * 만약 배열을 오름차순으로 정렬을 한다면
 * 앞 절반은 오름차순의 우선순위큐(중간부분이 나오도록)
 * 뒤 절반은 내림차순의 우선순위큐로 구현할 수 있다.
 * 
 * 꼭 모든 데이터를 합치지 않고도 정렬되어있는 상태를 만들수 있다!
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <queue>
#include <functional>

using namespace std;

struct comp1{
    bool operator() (int a, int b){
        return a > b;
    }
};
struct comp2{
    bool operator() (int a, int b){
        return a < b;
    }
};

priority_queue<int, vector<int>, comp2> leftQueue;
priority_queue<int, vector<int>, comp1> rightQueue; 

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int N, num;
    cin >> N;
    for(int i = 1; i <= N; i++){
        cin >> num;

        if(leftQueue.size() == rightQueue.size())
            leftQueue.push(num);
        else
            rightQueue.push(num);

        if((!leftQueue.empty() && !rightQueue.empty()) && (leftQueue.top() > rightQueue.top())){
            int tmp = leftQueue.top(); leftQueue.pop();
            leftQueue.push( rightQueue.top() );rightQueue.pop();
            rightQueue.push( tmp );
        }

        cout << leftQueue.top() << '\n';
    }

    return 0;
}