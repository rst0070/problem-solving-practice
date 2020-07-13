#include <iostream>
void inversive_reference();
int main(){
    int* addr;
    int i = 0;
    addr = &i;
    *addr+=-20;
    std::cout << addr << std::endl << i;
}

void inversive_reference(){
    char * pointer;
    char c = 'd';
    pointer = &c;
    *pointer -= 10;
    std::cout << c << std::endl;
}
    