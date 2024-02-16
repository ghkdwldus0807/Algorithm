def solution(s, n):
    answer = ''
    #z = 122, a = 97 , A= 65 , Z=90, 공백 = 32
    for i in range(len(s)):
        if ord(s[i]) == 32:
            answer += chr(32)
        elif 65<=ord(s[i])<=90 :
            answer += chr((ord(s[i])+n-65)%26+65)
        else :
            answer += chr((ord(s[i])+n-97)%26+97)
    
    

    return answer