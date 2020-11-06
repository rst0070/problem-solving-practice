/*
프로그램의 시간복잡도는 반복문이 결정하는가?
  일반적으로 프로그램은 입력의 크기에 대한 반복횟수가 정해진다.
  어떻게 보면 프로그램은 반복해서 조건에 맞는 일을 수행하는 것이기 때문이다.
  따라서 시간복잡도의 결과는 입력의 크기에 대한 반복문의 수행횟수가 된다.
  
  즉 시간복잡도를 생각할때는 반복문이 얼마나 수행되는지 집중해야한다.
*/

//예시1 주어진 배열에서 가장많이 등장한 수를 반환하는 함수

#include <iostream>
#include <vector>
#include <map>
using namespace std;
int mostFrequentNumber(vector<int>& array){
    map<int, int> m;
    for(vector<int>::size_type i=0; i < array.size(); i++){
        m[array[i]]++;
    }
    
    map<int, int>::iterator iter;
    map<int, int>::iterator answer = m.begin();
    
    for(iter = m.begin(); iter != m.end(); iter++){
        if(answer->second < iter->second) answer = iter;
    }
    return answer->first;
}
int main()
{
    vector<int> array;
    int input;
    cin >> input;
    for(int i=0; input >-1; i++){
        array[i] = input;
        cin >> input;
    }
    cout << mostFrequentNumber(array);
}
