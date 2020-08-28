N = int(input())
arr = []
for i in range(0,N):
    arr.append(input())
arr = list(set(arr))
arr = sorted(arr)
arr.sort(key=len)
for i in range(len(arr)):
    print(arr[i])