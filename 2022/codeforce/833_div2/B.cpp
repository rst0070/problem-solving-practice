/**
 * 각 숫자가 몇번 나오는지 저장
 * sub string의 최대 길이는 100
 */
#include <iostream>
#include <string>
using namespace std;

int occur[10];
int MAX_LEN;
int save[101];

void select(int kind, int remain_kind, int length, int now){
    if(length > MAX_LEN) return;

    if(now == 10){
        
    }
}

void solve(){
    int length;

    for(int i = 0; i < 10; i++) occur[i] = 0;
    for(int i = 0; i < 101; i++) save[i] = 0;

    cin >> length;
    MAX_LEN = length;
    char* str = new char[length];

    cin >> str;
    for(int i = 0; i < length; i++) occur[str[i] - '0']++;
        
        
    delete[] str;
    return;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int tc;
    cin >> tc;
    while(tc-- > 0){
        solve();
    }
    return 0;
}