import sys

count = int(input())

for i in range(0, count):
    a, b = map(int, sys.stdin.readline().split())
    print(a + b)