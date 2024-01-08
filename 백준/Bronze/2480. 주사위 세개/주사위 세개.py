a, b, c = map(int, input().split())

if a == b:
    if b == c:
        print(10000 + a * 1000)
    else:
        print(1000 + a * 100)
elif b == c:
    if c == a:
        print(10000 + a * 1000)
    else:
        print(1000 + b * 100)
elif c == a:
    if b == a:
        print(10000 + a * 1000)
    else:
        print(1000 + a * 100)
else:
    print(max(a, b, c) * 100)