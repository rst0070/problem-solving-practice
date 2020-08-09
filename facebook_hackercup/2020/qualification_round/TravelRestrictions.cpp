#include <iostream>
using namespace std;

bool r_in[50];
bool r_out[50];
int N;
int main(){
    int testCase;
    char str[50];
    char answer[50][50];
    cin >> testCase;

    for(int t=1; t <= testCase; t++){
        cin >> N >> str;
        int i, j;

        for(i=0; i < N; i++)
            r_in[i] = str[i]-'N';
        
        cin >> str;
        for(i=0; i < N; i++)
            r_out[i] = str[i]-'N';
        
        for(i=0; i < N; i++){
            if(!r_out[i]){
                

                continue;
            }
            for(j=0; j < N; j++){

            }
        }
        
    }
}