arr = []

for i in range(0, 9):
    a = int(input())
    arr.append(a)

print(max(arr))
print(arr.index(max(arr)) + 1)