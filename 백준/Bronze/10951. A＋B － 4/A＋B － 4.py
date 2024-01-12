import sys

while True:
    line = sys.stdin.readline()
    if line == "":
        break
    a, b = map(int, line.split())
    print(a + b)