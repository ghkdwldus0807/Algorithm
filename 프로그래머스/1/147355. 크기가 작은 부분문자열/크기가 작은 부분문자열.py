def solution(t, p):
    answer = 0
    arr = []
    length = len(p)
    
    for i in range(0,len(t)-length+1):
        arr.append(t[i:i+length])
    arr = list(map(int,arr))
    
    for i in arr:
        if i<=int(p) :
            answer +=1

    return answer