#include <iostream>
#include <vector>
using namespace std;

int main(){
    vector<int> v;
    //vector<int>::iterator it;

    v.insert(v.end(), 1);
    v.insert(v.end(), 2);
    v.insert(v.end(), 4);
    vector<int>::iterator it = v.begin();
    //v.insert(it, 3);
    v.erase(it);

    //for(int i=0; i < 4; i++)
        cout << (v.begin() == it);
}