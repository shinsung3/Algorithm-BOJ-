def main():
    n = int(input())
    print(pow(2,n)-1)
    recur(n, 1, 2, 3)
    # print(ans)
    result = ''.join(ans)
    print(result)

ans = []
def recur(n, start, mid, end):
    if n == 1:
        ans.append(str(start))
        ans.append(' ')
        ans.append(str(end))
        ans.append('\n')
    else:
        recur(n-1, start, end, mid)
        ans.append(str(start))
        ans.append(' ')
        ans.append(str(end))
        ans.append('\n')
        recur(n-1, mid, start, end)
        

if __name__ == "__main__":
    main()