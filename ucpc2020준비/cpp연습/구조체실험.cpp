#include <iostream>
#include <stack>
typedef struct _s{
    int x;
}S;
int main(){
    S a1;
    a1.x = 1;
    std::stack<S> ss;
    ss.push(a1);
    (ss.top()).x = 5;
    std::cout << a1.x;

/**
 * 결론: 값에 의한 호출로 push를 하므로 stack에는 복사된 구조체가 저장된다.
 * 
 */
}