#include <iostream>

int N, M;
char data[50][50];

int main(){
    std::cin >> N >> M;
    
    for(int i = 0; i < N; i++){
        std::cin >> data[i];
    }
    
    bool check = true;
    
    for(int i=N < M ? N-1:M-1; i >=0 && check; i--)
    for(int x = N-i-1; x > -1 && check; x--)
    for(int y=M-i-1; y > -1 && check; y--)
        if(data[x][y] == data[x+i][y] && 
            data[x][y]==data[x][y+i] && 
            data[x][y] == data[x+i][y+i]){

            std::cout << (i+1)*(i+1);
            check = false;
        }
    
}