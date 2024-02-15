def solution(arr):
    answer = []
    for i in arr :
        if i not in answer:
            answer.append(i)
        elif i in answer and answer[-1]!=i :
            answer.append(i)
    return answer