def solution(number):
    answer = 0
    
    for i in range(0,len(number)):
        for j in range(i+1,len(number)):
            for r in range(j+1,len(number)):
                if number[i]+number[j]+number[r]==0:
                    answer+=1
        
    return answer