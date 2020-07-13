#include <iostream>
#include <string>
using namespace std;
char c[] = {'U', 'C', 'P', 'C'};
int main(){
    string s;
    getline(cin, s);
    int p = 0;
    for(int i=0; i < s.length(); i++){
        if(s.at(i) == c[p]) p++;

    }

    if(p == 4) cout << "I love UCPC";
    else cout << "I hate UCPC";
}