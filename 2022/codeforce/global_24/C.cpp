/**
 * 
 * 
 */
#include <iostream>
using namespace std;

int gcd(int a, int b){
    if (b == 0) return a;
    return gcd(b, a % b);
}

int arr[100000];

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int tc;
    cin >> tc;
    while(tc-- > 0){
        
    }
    
    return 0;
}