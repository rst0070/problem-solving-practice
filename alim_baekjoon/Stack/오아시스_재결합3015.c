#include<stdio.h>

typedef struct Node
{
    /* data */
    int num;
    long long count;
} Node;

Node stack[500000];
int pointer = -1;

int isEmpty(){
    if(pointer < 0) return 1;
    return 0;
}

Node* peek(){
    //return stack + pointer*sizeof(Node);
    return &(stack[pointer]);
}

void pop(){
    pointer--;
}

void push(Node node){
    stack[++pointer] = node; 
}


int main(){
    int n;
    long long count = 0;
    scanf("%d", &n);
    n--;

    Node first;
    scanf("%d", &(first.num)); first.count = 1;
    push(first);

    while(n-- > 0){
        Node now; now.count = 1;
        scanf("%d", &(now.num));
        Node* in_stack;

        while(!isEmpty()){
            in_stack = peek();
            
            if(in_stack->num == now.num){
                count += in_stack->count;
                now.count += in_stack->count;
                pop();
                continue;
            }

            if(in_stack->num < now.num){
                count += in_stack->count;
                pop();
                continue;
            }

            if(in_stack->num > now.num){
                count++;//in_stack이 여러개 겹친 형태여도 맨 앞의 것만 쌍을 이룰 수 있다.
                push(now);
                break;
            }

            
        }

        if(isEmpty()) push(now);
    }

    printf("%lld\n", count);
    return 0;
}
