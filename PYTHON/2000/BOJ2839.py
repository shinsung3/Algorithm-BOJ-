def main():
    n = int(input())
    if n % 5 == 0:
        print(int(n/5))
    else:
        answer = 0
        while True:
            n -= 3
            if n < 0:
                print(-1)
                break
            answer += 1
            if n % 5 == 0:
                answer += n/5
                print(int(answer))
                break

if __name__ == "__main__":
	main()
