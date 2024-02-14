def solution(s):
    answer = True
    try:
        int(s)
    except : 
        answer=False
    else :
        return len(s)==4 or len(s)==6
    return answer