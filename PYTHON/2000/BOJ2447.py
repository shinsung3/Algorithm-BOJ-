
def main():
    ans = []
    n = int(input())
    for dy in range(n):
        for dx in range(n):
            flag = 1
            y = dy
            x = dx
            while y!=0:
                if y%3 == 1 & x%3== 1:
                    flag = 2
                    ans.append(' ')
                    break
                x = x//3
                y = y//3
            if flag ==1:
                ans.append('*')
        ans.append('\n')
    result = ''.join(ans)
    print(result)
           
if __name__ == "__main__":
	main()
