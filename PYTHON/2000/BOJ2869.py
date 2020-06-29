def main():
    a, b, v = input().split()
    a = int(a)
    b = int(b)
    v = int(v)
    answer = 1
    if a >= v:
        print(answer)
    else: 
        v-=a
        meter = a-b
        answer += v/meter
        if v%meter!=0:
            answer+=1
        print(int(answer))

if __name__ == "__main__":
	main()