def main():
    arr = [0 for i in range(42)]
    cnt = 0
    for i in range(10):
        n = input()
        temp = int(n)%42
        if arr[temp]==0:
            cnt+=1
        arr[temp]+=1
    
    print(cnt)

if __name__ == "__main__":
	main()