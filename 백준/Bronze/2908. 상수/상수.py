a, b = input().split()

a = reversed(a)
b = reversed(b)
a_reversed = ""
b_reversed = ""

for i in a:
    a_reversed = a_reversed + i

for i in b:
    b_reversed = b_reversed + i

int(a_reversed)
int(b_reversed)

if a_reversed > b_reversed:
    print(a_reversed)
elif a_reversed < b_reversed:
    print(b_reversed)
