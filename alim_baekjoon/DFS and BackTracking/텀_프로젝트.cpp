#include <iostream>
int N;
int list[100001];
int main(){
    int TestCase;
    std::cin >> TestCase;
    while(TestCase-- > 0){
        std::cin >> N;
        for(int i=1; i <= N; i++)   std::cin >> list[i];
    }
}