#include <iostream>
using namespace std;
int parent[501];

void init_parent(int n){
    for(int i = 1; i <= n; i++) parent[i] = i;
}

int find(int a){
    if(parent[a] == a) return a;
    return find(parent[a]);
}

void uni(int a, int b){
    a = find(a);
    b = find(b);
    if(a == b){parent[a] = 0; return;}
    if(a < b) parent[b] = a;
    else parent[a] = b;
}

int count_of_tree(int n){
    int result = 0;
    for(int i = 1; i <= n; i++)
        if(parent[i] == i) result++;
    return result;
}

int main(){
    int n, m, a, b;
    cin >> n >> m;
    int tc = 1;
    while(n != 0 || m != 0){
        init_parent(n);
        for(int i = m; i != 0; i--){
            cin >> a >> b;
            uni(a, b);
        }

        int count = count_of_tree(n);
        cout << "Case " << tc++ << ": ";
        if(count == 0)
            cout << "No trees." << endl;
        else if(count == 1)
            cout << "There is one tree." << endl;
        else 
            cout << "A forest of " << count << " trees." << endl;

        cin >> n >> m;
    }
}