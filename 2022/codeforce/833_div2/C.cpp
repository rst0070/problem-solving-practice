#include <iostream>
#include <map>

using namespace std;

long long sum[2*100000];
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    map<long long, int> count;

    int tc, N;
    long long tmp;
    cin >> tc;
    while(tc-- > 0){
        cin >> N >> sum[0];
        for(int i = 1; i < N; i++){
            cin >> tmp;
            sum[i] = sum[i-1] + tmp;
            
        }


    }
    return 0;
}