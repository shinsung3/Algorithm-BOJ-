S1, S2, S3 = map(int, input().split())
arr = [0 for i in range(S1+S2+S3+1)]
print(arr)
for i in range(S1):
    for j in range(S2):
        for k in range(S3):
            arr[i+j+k+3]+=1
max1 = max(arr)
for i in range(len(arr)):
    if arr[i] == max1:
        print(i)
        break