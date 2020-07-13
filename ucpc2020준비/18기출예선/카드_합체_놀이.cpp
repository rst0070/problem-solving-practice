//#include <algorithm>
#include <list>
#include <iostream>
using namespace std;
/**
 * 매번 합칠 때 마다 가장 작은 두 수를 찾아내야한다.
 * 입력값의 범위도 중요하게 살펴볼 것!
 */
int main(){
    int N, M;
    long long tmp;
    list<long long> q;
    list<long long>::iterator it;
    cin >> N >> M;
    while(N-- > 0){
        cin >> tmp;
        q.push_back(tmp);
    }

    q.sort();
    //it = q.begin();
    while(M-- > 0){
        tmp = q.front(); q.pop_front();
        tmp += q.front(); q.pop_front();
        
        for(it = q.begin(); it != q.end() && *it < tmp; it++);

        q.insert(it, tmp); q.insert(it, tmp);
    }

    tmp = 0;
    
    for(it = q.begin(); it != q.end(); it++)
        tmp+=*it;
    cout << tmp;
}