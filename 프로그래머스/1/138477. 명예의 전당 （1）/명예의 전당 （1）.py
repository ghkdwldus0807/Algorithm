def solution(k, score):
    answer = []
    result = [] 
    
    for i in range(len(score)):
        result.append(score[i])
        result.sort(reverse = True)
        if i<k :
            answer.append(result[i])
        else:
            answer.append(result[k-1])
        
    return answer