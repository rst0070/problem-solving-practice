/**
 * @file 11401_이항_계수_3.cpp
 * @author wonbin kim (kwb0711@gmail.com)
 * @brief 
 * @version 0.1
 * @date 2022-11-25
 * 
 * 이항계수 아이디어만 있으면 되는 문제인가?
 * nCk
 * 1 <= n <= 4,000,000
 * nCk = n-1Ck-1 + n-1Ck
 * 이 공식을 응용해서 dp를 적용하기엔 공간이 너무 많이 필요함
 * 페르마의 소정리 필요
 * a = a^p (mod p)
 * a^-1 = a^(p-2)
 * 
 * nCk = n! / {k! * (n-k)!}
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
using namespace std;

long long p = 1000000007; 

long long pow(int k, int n){
    if(n == 0) return 1;
    long long result = pow(k, n/2);
    result = (result * result) % p;
    if(n % 2 == 1)
        return (result * k) % p;
    return result;
}

int main(){
    long long n, k, result = 1, tmp;
    cin >> n >> k;

    if(k == 0){
        cout << 1 << endl;
        return 0;
    }

    for(long long r = (n - k + 1); r <= n; r++)
        result = (result * r) % p;
    tmp = k--;
    for(; k > 1; k--)
        tmp = (tmp * k) % p;

    result = (result * pow(tmp, p - 2)) % p;
    
    cout << result << endl;
    return 0;
}