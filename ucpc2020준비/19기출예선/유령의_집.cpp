#include <iostream>
#include <string>
#include <cstdlib>
#include <map>
#include <utility>

using namespace std;
int X, Y, K, Q;
/**
 * U: 0
 * L: 1
 * D: 3
 * R: 2
 */
//map<pair<int, int>, char> m;
map<int, map<int, char>> mm;

void defineDirection(int * ax, int * ay, int dir){
    switch(dir){
        case 0:
        (*ay)=1; (*ax) = 0;break;
        case 1:
        (*ax)=1; (*ay) = 0;break;
        case 3:
        (*ay)=-1; (*ax) = 0;break;
        case 2:
        (*ax)=-1; (*ay) = 0;break;
    }
}

int solve(int x, int y, int direction, int distance, int * sum_of_distance){
    
    int ax, ay, answer=0;
    
    char c;
    defineDirection(&ax, &ay, direction);
    while(x > 0 && y > 0 && x <= X && y <= Y){
        if((c = mm[x][y]) == 0){x = x+ax; y = y+ay; distance++;continue;}

        switch(c){
            case '!':
            (*sum_of_distance) += distance;
            answer += 1;
            break;

            case '/':
            direction = (direction+2)%4;
            defineDirection(&ax, &ay, direction);
            break;

            case 92:
            direction = (direction%2==0) ? (direction+1) : (direction-1);
            defineDirection(&ax, &ay, direction);
            break;
        }

        x = x+ax; y = y+ay; distance++;

    }

    return answer;
}


int main(){
    cin >> Y >> X >> K >> Q;
    int x, y;
    char c;
    for(int i = 0; i < K; i++){
        cin >> y >> x >> c;
        mm[x][y] = c;
    }  
    int sum, n_ghost;

    int ***check = new int**[4];
    check[0] = new int*[X+1];
    check[1] = new int*[Y+1];
    check[3] = new int*[X+1];
    check[2] = new int*[Y+1];

    for(int i = 1; i < X+1; i++){
        check[0][i] = new int[2]; check[0][i][0] = -1;
        check[3][i] = new int[2]; check[3][i][0] = -1;
    }
    for(int i = 1; i < Y+1; i++){
        check[1][i] = new int[2];check[1][i][0] = -1;
        check[2][i] = new int[2];check[2][i][0] = -1;
    }

    int dir, number;
    while(Q-- > 0){
        std::string str;
        std::cin >> str;

        switch(str.at(0)){
            case 'U':
            dir = 0; break;
            case 'L':
            dir = 1; break;
            case 'D':
            dir = 3; break;
            case 'R':
            dir = 2; break;
        }

        str = str.substr(1);
        number = atoi(str.c_str());

        sum = 0;    n_ghost = 0;
        if(check[dir][number][0] > -1){
            n_ghost = check[dir][number][0];
            sum = check[dir][number][1];
        }else{
            switch(dir){
                case 0:
                n_ghost = solve(number, 1, dir, 1, &sum);break;
                case 1:
                n_ghost = solve(1, number, dir, 1, &sum);break;
                case 3:
                n_ghost = solve(number, Y, dir, 1, &sum);break;
                case 2:
                n_ghost = solve(X, number, dir, 1, &sum);break;
            }
            
            check[dir][number][0] = n_ghost;
            check[dir][number][1] = sum;
        }

        std::cout << check[dir][number][0] << " " << check[dir][number][1] << std::endl;

    }

    delete check;
}