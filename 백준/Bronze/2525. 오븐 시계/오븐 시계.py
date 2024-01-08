h, m = map(int, input().split())
cooking_m = int(input())

total_time = h * 60 + m + cooking_m

h = int(total_time / 60)
m = total_time % 60

if h >= 24:
    h = h % 24

print(h, m)
