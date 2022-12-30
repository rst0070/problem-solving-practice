/**
 * 
 * 
 */
#include <iostream>
using namespace std;


int arr[100001];
int kind[100001];
bool vis[100001] = {0,};

int calc(int l, int r){
    return r - l - kind[r] + kind[l] - 1;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int tc;
    cin >> tc;
    while(tc-- > 0){
        int N;
        cin >> N;
        for(int i = 1; i <= N; i++){
            cin >> arr[i];
            if(vis[arr[i]]){
                kind[i] = kind[i-1];
            }else{
                kind[i] = kind[i-1] + 1;
                vis[arr[i]] = true;
            }
        }

        int l = 1, r = N;
        int l2, r2, c1 = calc(l, r), c2, c3;
        while( l < r ){
            l2 = l + 1; r2 = r - 1;
            c2 = calc(l2, r); c3 = calc(l, r2);

            if(c2 < c3){
                if(c3 > c1) r = r2;
                else break;
            }else{
                if(c2 > c1) l = l2;
                else break;
            }
        }
        cout << l << ' ' << r << '\n';

        for(int i = 0; i <= N; i++)
            vis[i] = false;
    }
    
    return 0;
}