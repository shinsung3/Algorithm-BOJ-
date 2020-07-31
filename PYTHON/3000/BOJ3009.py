arr = [0 for i in range(0,3)]
for i in range(0,3):
    arr[i] = list(map(int, input().split()))
x = 0
y = 0
for i in range(0, 3):
    for j in range(0, 3):
        if i==j:
            continue
        if arr[i][0] == arr[j][0]:
            arr[i][0] = -1
            arr[j][0 ]= -1
        if arr[i][1] == arr[j][1]:
            arr[i][1] = -1
            arr[j][1] = -1
for i in range(0, 3):
    if arr[i][0] != -1:
        x = arr[i][0]
    if arr[i][1] != -1:
        y = arr[i][1]
    if x!=0 and y!=0:
        break
print(str(x)+" "+str(y))