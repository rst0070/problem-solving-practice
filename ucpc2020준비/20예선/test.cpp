#include <iostream>
using namespace std;
int c_memo[300001][3];// combination nCr = c_memo[n][r-1]
int combination(int n, int r) { 
    if(n == r || r == 0) return 1;
    if(c_memo[n][r-1]) return c_memo[n][r-1];
    else return c_memo[n][r-1] = combination(n - 1, r) + combination(n - 1, r-1); 
}

int main(){
    int tc, n, r;
    cin >> tc;
    while(tc-- > 0){
        cin >> n >> r;
        cout << combination(n, r) << '\n';
    }
}