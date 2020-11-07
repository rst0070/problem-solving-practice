#include <iostream>
char data[6561][6561];

/*
재귀 방식으로 data에 프린트할 내용을 저장시킨다.
*/
void save(int size, int x, int y){
    if(size > 3){
        int nextSize = size/3;
        save(nextSize, x, y);
        save(nextSize, x + nextSize, y);
        save(nextSize, x + 2*nextSize, y);
        
        save(nextSize, x, y + nextSize);
        save(nextSize, x + 2*nextSize, y + nextSize);
        
        save(nextSize, x, y + 2*nextSize);
        save(nextSize, x + nextSize, y + 2*nextSize);
        save(nextSize, x + 2*nextSize, y + 2*nextSize);
        return;
    }
    data[x][y] = '*';
    data[x+1][y] = '*';
    data[x+2][y] = '*';
    
    data[x][y+1] = '*';
    data[x+2][y+1] = '*';
    
    data[x][y+2] = '*';
    data[x+1][y+2] = '*';
    data[x+2][y+2] = '*';
    
}

int main(){
    int n;
    std::cin >> n;
    save(n, 0, 0);
    for(int i=0; i<n; i++){
        for(int j=0; j < n; j++){
            if(data[j][i]) std::cout << data[j][i];
            else std::cout << ' ';
        }
        std::cout << std::endl;
    }
    return 0;
}

