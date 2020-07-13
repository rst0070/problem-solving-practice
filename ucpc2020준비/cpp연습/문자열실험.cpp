#include <string>
#include <iostream>
#include <cstdlib>
int main(){
    std::string str;
    std::cin >> str;

    char c = str.at(0);
    str = str.substr(1);
    int i = atoi(str.c_str());

    std::cout << c << ' ' << str << ' ' << i;
}