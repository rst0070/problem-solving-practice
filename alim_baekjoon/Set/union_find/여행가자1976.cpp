#include<iostream>
using namespace std;

int N, M;
int parent[201];
int cities[201] = {0,};

int find(int a){
    if(a == parent[a]) return a;
    return find(parent[a]);
}

void uni(int a, int b){
    a = find(a);
    b = find(b);
    if(a == b) return;

    if(a < b) parent[b] = a;
    else parent[a] = b;
}

int main(){
    cin >> N >> M;

    for(int i = 1; i <= N; i++) parent[i] = i;

    //그래프 저장대신 union
    int connect;
    for(int i = 1; i <= N; i++)
        for(int j = 1; j <= N; j++){
            cin >> connect;
            if(connect) uni(i, j);
        }

    //루트 비교
    bool possible = true;
    int a, b;
    cin >> a;
    a = find(a);
    for(int i = 1; i < M; i++){
        cin >> b;
        if(find(b) != a){
            possible = false;
            break;
        }
    }

    if(possible)    cout << "YES";
    else    cout << "NO";
    
}