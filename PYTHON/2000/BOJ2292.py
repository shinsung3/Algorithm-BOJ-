def main():
    n = int(input())
    answer = 1
    if n == 1:
        print(answer)
    else:
        idx = 1
        while True:
            answer += 6*idx
            if answer >= n:
                print(idx+1)
                break
            idx += 1


if __name__ == "__main__":
	main()
