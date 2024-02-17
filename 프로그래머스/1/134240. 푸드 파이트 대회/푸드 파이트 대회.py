def solution(food):
    answer = ''
    for i in range(1,len(food)):
        answer += str(i) * (food[i]//2)
    
    answer_right = answer[::-1]
    answer = answer + '0' + answer_right
    
    return answer