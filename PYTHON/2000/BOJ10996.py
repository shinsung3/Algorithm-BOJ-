n = int(input())
ans = []
if n == 1:
    print("*")
else:
    for i in range(0,n):
        if i%2==0:
            ans.append("*")
        else:
            ans.append(" ")
    ans.append("\n")
    for i in range(0,n):
        if i%2==0:
            ans.append(" ")
        else:
            ans.append("*")
    result = ''.join(ans)
    for i in range(1, n):
        print(result)
    print(result)