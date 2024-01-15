s = input()

word_list = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
count = 0
i = 0


while i < len(s):
    if i < len(s) - 2 and s[i : i + 3] in word_list:
        count = count + 1
        i = i + 3
    elif i < len(s) - 1 and s[i : i + 2] in word_list:
        count = count + 1
        i = i + 2
    else:
        count = count + 1
        i = i + 1


print(count)