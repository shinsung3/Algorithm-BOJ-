N, score, P = map(int, input().split())
idx = 0
if N !=0:
    arr = list(map(int, input().split()))
# print(arr)

idx = 1
cnt = 1
for i in range(N):
    if arr[i] < score:
        break
    elif arr[i] > score:
        cnt+=1
    idx+=1
    if idx > P:
        break
if idx > P:
    print(-1)
else:
    print(cnt)