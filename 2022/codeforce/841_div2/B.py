tc = int(input())
mod = 1000000007
list = []
while tc > 0:
    n = int(input())
    n2 = n*n
    n3 = n*n*n
    ans = (4*n3 + 3*n2 - n)
    ans = (ans * 337) % mod
    list.append(ans)
    tc -= 1
    
for i in list:
    print(i)