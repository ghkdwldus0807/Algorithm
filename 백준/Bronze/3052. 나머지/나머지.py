num = []

for i in range(0, 10):
    a = int(input())
    result = a % 42
    if result not in num:
        num.append(result)

print(len(num))