n = int(input())

blank = " "
star = "*"

for i in range(1, 2 * n):
    if 1 <= i <= n:
        print(blank * (n - i) + star * (2 * i - 1))
    else:
        print(blank * (i - n) + star * (4 * n - 2 * i - 1))