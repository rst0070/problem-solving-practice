#include <iostream>
#include <vector>
using namespace std;
int N;
int bitOfA[29];

vector<int> A, B;
int solveAndPlus(){
    int answer = 0;

    int sum[29];
    for(int i=0; i < 29; i++) sum[i] = 0;
    for(int b : B){
        for(int i = 0; i < 29; i++)
            if(bitOfA[i] && ((1 << i)&b)) sum[i] = bitOfA[i];
    }

    for(int i = 0; i < 29; i++){
        if(sum[i] == 0) continue;

        answer += ((1 << i)*sum[i]) % 1999;
        answer = answer % 1999;
    }
    return answer;
}

int solvePlusAnd(){

}

int main(){
    cin >> N;
    int a, b, j;

    for(int i=0; i < N; i++){
        cin >> a;
        for(j=0; j < 29; j++)
            if((1 << j) & a)   bitOfA[j]++;
    }

    for(int i=0; i < N; i++){
        cin >> b;
        B.push_back(b);
    }

    cout << solveAndPlus() << ' ' << 0%1999;
}