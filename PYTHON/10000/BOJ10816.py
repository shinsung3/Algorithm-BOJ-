N = input()
arr = list(map(int, input().split()))
M = input()
cards = list(map(int, input().split()))
minus = [0 for i in range(10000000)]
plus = [0 for i in range(10000000)]


for i in range(len(arr)):
    if arr[i] < 0:
        minus[arr[i]]+=1
    else:
        plus[arr[i]]+=1

answer = ""
for i in range(len(cards)):
    if cards[i] < 0:
        answer += str(minus[cards[i]]) +" "
    else:
        answer += str(plus[cards[i]]) + " "

print(answer)
