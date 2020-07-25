#include <iostream>
using namespace std;
int N, M;
int trees[1000000];
int search(int begin, int end){
    if(begin > end) return end;
    int mid = (begin+end)/2;

    int sum=0, tmp;
    for(int i=0; i < N; i++){
        if(tmp = trees[i]-mid <= 0) continue;
        sum += tmp;
    }

    if(sum == M) return mid;
    

}
int main(){
    cin >> N >> M;
    int tmp, maxTree=0;;
    for(int i=0; i<N; i++){
        cin >> tmp;
        maxTree = tmp > maxTree ? tmp : maxTree;
        trees[i] = tmp;
    }

    int begin = maxTree - M, end = maxTree-1;
    begin = begin < 0 ? 0 : begin;

    cout << search(begin, end);
}