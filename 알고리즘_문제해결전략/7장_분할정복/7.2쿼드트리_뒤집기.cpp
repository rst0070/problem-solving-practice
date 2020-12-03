#include <iostream>
#include <string>
using namespace std;
string tree;

string solve(int * pointer){
    char isX = tree[*pointer];
    (*pointer)++;
    if(isX != 'x') return string(1, isX);
    
    string s1 = solve(pointer);
    string s2 = solve(pointer);
    string s3 = solve(pointer);
    string s4 = solve(pointer);
    
    return "x" + s3 + s4 + s1 + s2;
}
int main(){
    int c;//number of test cases
    int d=0;
    cin >> c;
    while(c-- > 0){
        cin >>tree;
        cout << solve(&d) << endl;
        d=0;
    }
}
