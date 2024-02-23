from collections import deque

def solution(priorities, location):
    answer = 0
    data = deque(enumerate(priorities))
    
    while data :
        max_v = max(data, key = lambda x : x[1])[1]
        index, priority = data.popleft()
        if priority < max_v:
            data.append((index,priority))
        else :
            answer +=1
            if index == location :
                break

    
    
    return answer