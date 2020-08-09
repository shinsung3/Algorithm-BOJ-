N, m, M, T, R = map(int, input().split())
#N분, M보다 작아야 됨
# m보다 작으면 m이 됨 -> m은 기본 맥박
# T만큼커짐
# R만큼 작아짐

minn = m
ans = 0
minute = 0
if m>M or m + T > M:
    minute = -1
else:
    while True:
        m+=T
        if m<=M:
            ans+=1
            minute+=1
        else:
            m-=T
            m-=R
            if m <minn:
                m = minn
            minute+=1
        if ans >= N:
            break
print(minute)