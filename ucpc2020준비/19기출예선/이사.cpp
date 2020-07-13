#include <iostream>
int n;
int data[1000][2];
int main(){
    std::cin >> n;
    for(int i = 0; i < n; i++){
        std::cin >> data[i][0] >> data[i][1];
    }

    int length = 2147483647, j;
    int answer;
    int a, b;
    for(int i=0; i < n; i++){
        int max = 0;
        for(j=0; j < n; j++){
            if(i==j)continue;
            a = data[j][0] - data[i][0];
            b = data[j][1] - data[i][1];
            max = (a = a*a + b*b)>max ? a : max;
        }
        if(max < length){
            length = max;
            answer = i;
        }
    }

    std::cout << data[answer][0] << " " << data[answer][1] << std::endl;
}