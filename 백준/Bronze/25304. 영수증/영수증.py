total = int(input())
count = int(input())
sum = 0

for i in range(0, count):
    a, b = map(int, input().split())
    sum = sum + a * b

if total == sum:
    print("Yes")
else:
    print("No")