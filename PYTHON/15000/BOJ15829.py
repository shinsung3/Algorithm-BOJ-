n = int(input())
alphabet = list(input())

ans = 0
idx = 0
for i in range(n):
    num = ord(alphabet[i])-ord('a')
    a = num+1
    r = 1
    for j in range(idx):
        r = r*31
    ans += r*a
    idx+=1
print(ans % 1234567891)
