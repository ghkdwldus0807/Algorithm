def solution(n):
    answer = 0
    tmp = ''
    
    while n:
        tmp += str(n%3)
        n = n//3
    
    answer = int(tmp, 3)
    
    return answer