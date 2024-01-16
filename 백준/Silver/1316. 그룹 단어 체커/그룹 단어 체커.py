n = int(input())
word_list = []
result = n

for i in range(n):
    word = input()
    for j in range(1, len(word)):
        if word[j] != word[j - 1] and word[j] in word_list:
            result -= 1
            break
        elif word[j] != word[j - 1] and word[j - 1] not in word_list:
            word_list.append(word[j - 1])

    word_list = []

print(result)