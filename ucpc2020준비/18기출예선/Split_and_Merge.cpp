/**
 * 두개의 bitstring 을 갖게 만드는데 필요한 연산의 횟수.
 * 
 * 같은 bit는 그대로 나두면 된다.
 * 
 * 
 * 
 * 
 * 
 */
#include <iostream>
using namespace std;
int main(){
    int tmp = 1;
    for(int i=1; i < 3001; i++)
        tmp *= i;
    cout << tmp;
}