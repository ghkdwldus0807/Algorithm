def solution(name, yearning, photo):
    answer = []
    for row in range(len(photo)):
        score = 0
        for i in range(len(name)):
            if name[i] in photo[row]:
                score += yearning[i]
        answer.append(score)
    return answer