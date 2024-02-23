def solution(s):
    answer = True
    stack = []
    
    count = 0 
    
    for i in s : 
        if s[0] ==')':
            answer = False
            break
        if i == '(':
            stack.append(i)
        elif i == ')' and stack :
            stack.pop()
            
    
    if stack :
        answer = False

    

    return answer