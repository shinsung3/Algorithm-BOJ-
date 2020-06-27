def main():
    max = 0
    idx = 0
    for i in range(9):
        n = input()
        if int(n) > max:
            max = int(n)
            idx = i+1
    print(max)
    print(idx)

if __name__ == "__main__":
	main()