#include<iostream>
using namespace std;

/**
 * 3개의 점이 일직선에 있는 경우는 없다. 
 */
struct Point{
    long long x, y;
};

int orientation(Point p, Point q, Point r){
    long long val = (r.x - p.x)*(q.y - p.y) - (q.x - p.x)*(r.y - p.y); 
    if(val < 0) return -1;
    if(val > 0) return 1;
    return 0;
}

int main(){
    Point la1, la2, lb1, lb2;
    cin >>  la1.x >> la1.y >> la2.x >> la2.y;
    cin >>  lb1.x >> lb1.y >> lb2.x >> lb2.y;

    int ab1 = orientation(la1, la2, lb1);
    int ab2 = orientation(la1, la2, lb2);
    int ba1 = orientation(lb1, lb2, la1);
    int ba2 = orientation(lb1, lb2, la2);

    int result = 0;
    if(ab1 != 0 && ab2 != 0 && ab1 != ab2 && ba1 != 0 && ba2 != 0 && ba1 != ba2) result = 1;
    cout << result << endl;
}