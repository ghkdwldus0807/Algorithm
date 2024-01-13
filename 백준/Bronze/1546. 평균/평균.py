import sys

n = int(input())

scores = list(map(int, sys.stdin.readline().split()))

max_score = max(scores)
scores = list(map(lambda x: x / max_score * 100, scores))

average = sum(scores) / n

print(average)