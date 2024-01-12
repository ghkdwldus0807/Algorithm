count = int(input())

for i in range(1, count + 1):
    blank = " " * (count - i)
    star = "*" * i
    print(blank + star)