import sys

a = int(input())
arr = list(map(int, sys.stdin.readline().split()))
num = int(input())
count = 0

for i in range(0, a):
    if arr[i] == num:
        count = count + 1

print(count)