import sys

n = int(input())
arr = list(map(int, sys.stdin.readline().split()))
max = -1000001
min = 1000001

for i in range(0, n):
    if arr[i] > max:
        max = arr[i]
    if arr[i] < min:
        min = arr[i]

print(min, max)