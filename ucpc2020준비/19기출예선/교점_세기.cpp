#include <iostream>
#include <queue>
using namespace std;
int f[2], g[3], h[3];
/**
 * - : 0
 * + : 1
 * 0 : 2
 */
int main(){
    int n, tmp, i;
    cin >> n;

    char c;
    while(n-- > 0){
        cin >> c >> tmp;
        if(tmp<0) i=0;
        else if(tmp > 0) i=1;
        else   i = 2;
        
        switch(c){
            case '/':
            f[i]++;break;
            case '^':
            g[i]++;break;
            case '*':
            h[i]++;break;
            
        }
    }
}