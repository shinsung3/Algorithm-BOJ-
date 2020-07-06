def main():
    n = int(input())
    if n == 0:
        print(1)
    else:
        a = solution(n)
        print(a)


def solution(n):
    if n == 1:
        return 1
    else:
        return n*solution(n-1)


if __name__ == "__main__":
	main()
