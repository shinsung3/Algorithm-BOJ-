def main():
    burger = [0 for i in range(3)]
    juice = [0 for i in range(2)]
    for i in range(3):
        burger[i] = int(input())
    for i in range(2):
        juice[i] = int(input())

    burger = sorted(burger)
    juice = sorted(juice)
    ans = burger[0] + juice[0] - 50
    print(ans)


if __name__ == "__main__":
	main()
