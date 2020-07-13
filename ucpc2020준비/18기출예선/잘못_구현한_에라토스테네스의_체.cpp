#include <iostream>

/**
 * root n 보다 작거나 같은 소수들을 찾는다.
 * 각각의 소수를 i라 할때 1부터 floor(n/i)+1까지의 합들의 합이 답이다. 
 * 왜냐하면 제시된 코드는 소수가 아닌것 까지 시드로 사용하여 에라토스테네스의 체를 잘못 사용하기 때문.
 * 즉, i, 2i, 3i, ... floor(n/i)모두를 시드로 사용한다. 또 이 각각에 1번씩 추가로 연산이 실행된다.
 * 따라서 연산횟수가 floor(n/i) + floor(n/2i) ...이 되는것.
 */

bool prime_numbers[1001];
void find_prime_numbers(int n){
    
    int i=2, p=2;
    while(p*p <=n){
        for(; p*p <= n; p += p) prime_numbers[p] = false;

        while(!prime_numbers[i])i++;
        p = i;
    }
}
int main(){
    for(int i = 2; i <= 1000; i++) prime_numbers[i] = true;
    int n, answer;
    std::cin >> n;
    
    

    /**
     * 5
     * 0
     * 1
     * 2
     * 1
     * 0
     * 
     * 6
     * 0
     * 0
     * 0
     * 2
     * 1
     * 0
     * 
     * 12
     * 6*2
     * 4*3
     * 3*4
     * 2*5
     * 2*6
     * 
     */
}