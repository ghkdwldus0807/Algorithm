import sys

n, x = map(int, input().split())
arr = list(map(int, sys.stdin.readline().split()))
arr2 = []

for i in range(0, n):
    if arr[i] < x:
        arr2.append(arr[i])

print(*arr2)