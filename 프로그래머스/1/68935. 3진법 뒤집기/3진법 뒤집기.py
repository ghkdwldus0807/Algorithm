def solution(n):
    answer = 0
    ternary = []
    answer_list = []
    a = n
    while a>0 :
        ternary.insert(0,a%3)
        a = a//3
    
    ternary.reverse()
    
    for i in range (0, len(ternary)) :
        if ternary[i] == 0 :
            continue
        else :
            answer_list.append(ternary[i]*3**(len(ternary)-i-1))
    answer = sum(answer_list)
    return answer