#include <iostream>
int map[3000][3000];
int R, C, K;
long long search(int r, int c, int rcount){
  if(r >= R || c >= C) return 0;
  long long a = search(r+1, c, 0);
  long long b = search(r, c+1, rcount);
  long long cc = 0;
  if(rcount < 3){
    a += map[r][c];
    cc = search(r, c+1, rcount+1) + map[r][c];
  }
  
  a = a > b ? a : b;
  a = a > cc ? a : cc;
  return a;
}
int main(){
  std::cin >> R >> C >> K;
  int r, c, d;
  while(K-- > 0){
    std::cin >> r >> c >> d;
    map[r][c] = d;
  }
  std::cout << search(0, 0, 0);
}
