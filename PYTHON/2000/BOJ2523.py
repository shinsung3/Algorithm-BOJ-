n = int(input())
ans = []
for i in range(0, n):
    for j in range(0,i+1):
        ans.append("*")
    ans.append("\n")
for i in range(0,n-1):
    for j in range(0, n-i-1):
        ans.append("*")
    if i!=n-2:
        ans.append("\n")

result = ''.join(ans)
print(result)