a = int(input())
arr = []
for i in range(a):
    isZero = int(input())
    if isZero != 0:
        arr.append(isZero)
    else:
        arr.pop()

sum = 0
for i in range(len(arr)):
    sum += arr[i]

print(sum)
