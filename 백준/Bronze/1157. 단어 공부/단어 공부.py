s = input()

s = s.upper()

word_count = [0 for i in range(26)]

for i in range(len(s)):
    word_count[ord(s[i]) - 65] = word_count[ord(s[i]) - 65] + 1

find_max_count = []
for i in range(len(word_count)):
    if word_count[i] != 0:
        find_max_count.append(word_count[i])

max_count = 0

for i in range(len(find_max_count)):
    if find_max_count[i] == max(find_max_count):
        max_count = max_count + 1

if max_count == 1:
    print(chr(word_count.index(max(word_count)) + 65))
else:
    print("?")
