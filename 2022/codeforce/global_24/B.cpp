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
        int N;
        cin >> N;
        for(int i = 0; i < N; i++)
            cin >> arr[i];

        int small = arr[0];
        for(int i = 1; i < N; i++)
            small = gcd(small, arr[i]);

        cout << arr[N-1] / small << '\n';
    }
    
    return 0;
}