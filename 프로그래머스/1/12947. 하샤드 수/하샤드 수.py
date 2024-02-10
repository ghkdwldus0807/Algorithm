def solution(x):
    answer = True
    str_x = str(x)
    sum_x = sum(int(i) for i in str_x)
    
    if x%sum_x != 0 :
        answer = False
    return answer