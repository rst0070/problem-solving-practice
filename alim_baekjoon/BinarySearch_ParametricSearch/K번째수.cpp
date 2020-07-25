#include <iostream>
using namespace std;
int N, K;
int binarySearch(int begin, int end){
    int mid = (begin+end)/2, tmp = mid*mid;
    if(tmp == K) return mid;

    if(tmp < K) return binarySearch(mid, end);
    else return binarySearch(begin, mid);

}
int main(){
    cin >> N >> K;
    cout << binarySearch(1, N);
}