#include <iostream>
using namespace std;
int data[20000];
int max(int a, int b){
    if(a > b) return a;
    else return b;
}
int min(int a, int b){
    if(a > b) return b;
    else return a;
}
int findBox(int start, int end){
    if(start == end) return data[start];
    
    int mid = (start+end)/2;
    
    int answer = max(findBox(start, mid), findBox(mid+1, end));
    
    int l = mid;
    int r = mid;
    int height = data[mid];
    
    while(start <= l && r < end){
        if(start < l && data[l-1] > data[r+1]){
            l--;
            height = min(height, data[l]);
        }else{
            r++;
            height = min(height, data[r]);
        }
        
        answer = max(answer, (r-l+1)*height);
    }
    
    return answer;
}

int main(){
    int c;//number of test cases
    int n;
    cin >> c;
    while(c-- > 0){
        cin >> n;
        for(int i=0; i < n; i++) cin >> data[i];
        cout << findBox(0, n-1) << endl;
    }
}
