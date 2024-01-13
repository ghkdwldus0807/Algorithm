n, m = map(int, input().split())
basket = [0 for i in range(n)]

for a in range(0, m):
    i, j, k = map(int, input().split())
    for r in range(i - 1, j):
        basket[r] = k

print(*basket)
