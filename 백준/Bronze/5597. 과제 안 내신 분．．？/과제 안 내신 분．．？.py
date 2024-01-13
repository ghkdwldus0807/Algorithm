student = [0 for i in range(0, 30)]

for i in range(0, 28):
    num = int(input()) - 1
    student[num] = 1

for i in range(0, 30):
    if student[i] == 0:
        print(i + 1)
