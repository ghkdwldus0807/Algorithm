t = int(input())
for r in range(t):
    n, s = input().split()
    n = int(n)
    result = ""

    for i in range(len(s)):
        result = result + s[i] * n

    print(result)