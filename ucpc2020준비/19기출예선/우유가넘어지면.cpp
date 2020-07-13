#include <iostream>
#include <stdlib.h>
int main(){
    int m, n, i, j;
    std::cin >> n >> m;
    char **data;//data[n][m]
    data = (char **)malloc(sizeof(char *)*n);
    for(i = 0; i < n; i++){
        data[i] = (char *)malloc(sizeof(char *)*m);
        std::cin >> data[i];
        for(j = 0; j < m; j++){
            switch(data[i][j]){
                case 45:
                data[i][j] = 124; break;
                case 124:
                data[i][j] = 45; break;
                case 47:
                data[i][j] = 92; break;
                case 92:
                data[i][j] = 47; break;
                case 94:
                data[i][j] = 60; break;
                case 60:
                data[i][j] = 118; break;
                case 118:
                data[i][j] = 62; break;
                case 62:
                data[i][j] = 94; break;
            }
        }
    }

    for(i = m-1; i > -1 ; i--){
        for(j = 0; j < n; j++)
            std::cout << data[j][i];
        std::cout << std::endl;
    }
        


    
}