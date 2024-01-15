s = input()
time = 0


for i in range(len(s)):
    if s[i] in ["A", "B", "C"]:
        time = time + 3
    elif s[i] in ["D", "E", "F"]:
        time = time + 4
    elif s[i] in ["G", "H", "I"]:
        time = time + 5
    elif s[i] in ["J", "K", "L"]:
        time = time + 6
    elif s[i] in ["M", "N", "O"]:
        time = time + 7
    elif s[i] in ["P", "Q", "R", "S"]:
        time = time + 8
    elif s[i] in ["T", "U", "V"]:
        time = time + 9
    elif s[i] in ["W", "X", "Y", "Z"]:
        time = time + 10
print(time)