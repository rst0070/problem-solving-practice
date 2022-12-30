/**
 * 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 으로 이어짐
 * 홀수일때..
 * 
 */
#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int tc, N;
    cin >> tc;
    while(tc-- > 0){
        cin >> N;
        if(N % 2 == 0) cout << N/2;
        else cout << N/2 + 1;
        cout << '\n';
    }
    return 0;
}