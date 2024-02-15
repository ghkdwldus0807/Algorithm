def solution(d, budget):
    answer = 0
    
    while sum(d)>=budget :
        if sum(d) == budget:
            break
        d.remove(max(d))
    
    answer = len(d)
    return answer