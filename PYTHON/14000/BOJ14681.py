x = int(input())
y = int(input())

ans = 0
if x>0 and y>0:
    ans = 1
elif x>0 and y<0:
    ans = 4
elif x<0 and y>0:
    ans = 2
elif x<0 and y<0:
    ans = 3
print(ans)