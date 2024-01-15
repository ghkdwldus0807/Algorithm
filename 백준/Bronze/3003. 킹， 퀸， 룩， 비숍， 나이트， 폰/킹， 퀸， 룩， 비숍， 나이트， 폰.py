black = [1, 1, 2, 2, 2, 8]
white = list(map(int, input().split()))

result = [a - b for a, b in zip(black, white)]

print(*result)