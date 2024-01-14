word = input()
place = [-1 for i in range(26)]

for i in range(len(word)):
    if place[ord(word[i]) - 97] == -1:
        place[ord(word[i]) - 97] = i

print(*place)