while True:
    x,y,z = map(int, input().split())
    if x==0 and y==0 and z==0:
        break
    maxValue = max(x,y,z)
    arr = [0 for i in range(0,3)]

    arr[0] = x
    arr[1] = y
    arr[2] = z

    sumValue = 0
    for i in arr:
        if maxValue != i:
            sumValue += i**2

    maxValue = maxValue**2
    ans = ''
    if maxValue == sumValue:
        ans = 'right'
    else:
        ans = 'wrong'
    print(ans)