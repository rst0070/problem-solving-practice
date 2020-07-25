#include <iostream>
#include <vector>
using namespace std;
int N;
vector<int> graph[300001];


int c_memo[300001][3];// combination nCr = c_memo[n][r-1]
int combination(int n, int r) { 
    if(n == r || r == 0) return 1;
    if(c_memo[n][r-1]) return c_memo[n][r-1];

    return c_memo[n][r-1] = combination(n - 1, r) + combination(n - 1, r-1); 
}

int dfs(int prev, int n, int depth){
    if(depth == 2)  return graph[n].size()-1;
    int re = 0;
    for(int next : graph[n]){
        if(next == prev) continue;
        re += dfs(n, next, depth+1);
    }
    return re;
}

int main(){

    cin >> N;
    int u, v;
    for(int i=1; i < N; i++){
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    int i_size=0;
    int type1 = 0;
    int type2 = 0;
    for(int i=1; i <= N; i++){
        i_size = graph[i].size();
        
        if(i_size > 2){
            type1 = type1 + combination(i_size, 3);
            //cout << "type1: " << type1 << '\n';
        } 

        type2 = type2 + dfs(-1, i, 0);
        
    }
    type1 = 3*type1;
    
    type2 = (type2)/2;

    //cout << type1 << ' ' << type2 << '\n';
    if(type2 > type1)   cout << 'D';
    else if(type1 == type2) cout << "DUDUDUNGA";
    else cout << 'G';

    cout << '\n';
}