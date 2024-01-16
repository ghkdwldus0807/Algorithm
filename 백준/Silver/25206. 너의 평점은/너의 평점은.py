import sys

total_score = 0
subject_count = 0

for i in range(20):
    subject, credit, score = sys.stdin.readline().split()
    credit = int(credit[0])
    if score == "A+":
        total_score = total_score + credit * 4.5
        subject_count = subject_count + credit
    elif score == "A0":
        total_score = total_score + credit * 4.0
        subject_count = subject_count + credit
    elif score == "B+":
        total_score = total_score + credit * 3.5
        subject_count = subject_count + credit
    elif score == "B0":
        total_score = total_score + credit * 3.0
        subject_count = subject_count + credit
    elif score == "C+":
        total_score = total_score + credit * 2.5
        subject_count = subject_count + credit
    elif score == "C0":
        total_score = total_score + credit * 2.0
        subject_count = subject_count + credit
    elif score == "D+":
        total_score = total_score + credit * 1.5
        subject_count = subject_count + credit
    elif score == "D0":
        total_score = total_score + credit
        subject_count = subject_count + credit
    elif score == "F":
        subject_count = subject_count + credit

print(total_score / subject_count)