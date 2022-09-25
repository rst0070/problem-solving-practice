#include <iostream>
#include <cstdlib>
using namespace std;

int center[20001];
int dist[20001];

void initData(int n){
    for(int i = 1; i <= n; i++){
        center[i] = i;
        dist[i] = 0;
    }
}

int findCenter(int l){
    if(l == center[l]) return l;
    int root = findCenter(center[l]);//기업l의 부모들의 dist최신화 & 가장 center 반환
    dist[l] += dist[center[l]];
    return center[l] = root;
}

/**
 * @param i 는 이미 센터인 상황
 * @param j 는 센터이거나 센터에 연결된 기업인 경우
 * 거리를 구하기 위해 i의 센터를 j로 간주.
 */
void linkToJ(int i, int j){
    dist[i] = abs(i-j) % 1000;
    center[i] = j;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int tc, n, i, j;
    char order;
    cin >> tc;

    while(tc-- != 0){

        cin >> n;
        initData(n);

        while(true){
            cin >> order;
            if(order == 'O') break;

            if(order == 'E'){
                cin >> i;
                findCenter(i);
                cout << dist[i] << '\n';
            }else{
                cin >> i >> j;
                linkToJ(i, j);
            }
        }
    }
    return 0;
}