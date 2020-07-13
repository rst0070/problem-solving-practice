#include <map>
#include <iostream>
using namespace std;
typedef struct v{
    int id;
}Value;
map<int,map<int, Value>> m;

int main(){
    Value vv;
    vv.id = 1;
    m[1][1] = vv;
    cout << m[0][0].id;
}