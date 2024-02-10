def solution(a, b):
    answer = 0
    if a>b :
        num = a - b
        for i in range (0,num+1):
            temp = b+i
            answer += temp
    elif b>a:
        num = b-a
        for i in range (0,num+1):
            temp = a+i
            answer += temp
    else :
        answer = a
    return answer