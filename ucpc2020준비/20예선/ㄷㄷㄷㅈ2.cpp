#include <iostream>
#include <vector>
using namespace std;
int N;
vector<int> graph[300001];
int d_memo[300001][4];
bool d_check[300001][4];

int c_memo[300001][3];// combination nCr = c_memo[n][r-1]
int combination(int n, int r) { 
    if(n == r || r == 0) return 1;
    if(c_memo[n][r-1]) return c_memo[n][r-1];

    return c_memo[n][r-1] = combination(n - 1, r) + combination(n - 1, r-1); 
}
bool visited[300001];
int dfs(int n, int depth){
    //cout << n << ',' << depth << '\n';
    if(depth > 3) return 0;
    if(d_check[n][depth]) return d_memo[n][depth];
    d_check[n][depth] = true;

    if(depth == 3) return d_memo[n][depth] = 1;

    int re=0, tmp = - dfs(n, depth+2);
    for(int next : graph[n]){
        re += dfs(next, depth+1) + tmp + dfs(next, depth+3);
        //cout << re << '\n';
    }



    return d_memo[n][depth] = re;
}
/*
int dfs(int n, int depth){
    if(depth > 3) return 0;
    if(depth == 3) return 1;
    int answer = 0;
    int tmp = - dfs(n, depth+2);
    //depth == 1 ? - dfs(n, depth+2) : 0;
    for(int next : graph[n]){
        answer += dfs(next, depth+1) + tmp + dfs(next, depth+3);
    }
    return answer;
}*/
/*
    if(re <= 0) d_memo[n][depth] = 0;
    else d_memo[n][depth] = re;*/
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

        type2 = type2 + dfs(i, 0);
        
    }
    type1 = 3*type1;
    
    type2 = (type2)/2;

    //cout << type1 << ' ' << type2 << '\n';
    if(type2 > type1)   cout << 'D';
    else if(type1 == type2) cout << "DUDUDUNGA";
    else cout << 'G';

    cout << '\n';
}