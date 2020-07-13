#include <iostream>
int main(){
    int N;
    std::cin >> N;

    if(N <= 5){
        std::cout << N << std::endl;
    }else{
        int j = 1;
        int tmp;
        N = N - 5;
        j = j + N/4;
        if(j%2 == 0)
            std::cout << 1+N%4 << std::endl;
        else
        {
            std::cout << 5 - N%4 << std::endl;
        }
        
    }
}