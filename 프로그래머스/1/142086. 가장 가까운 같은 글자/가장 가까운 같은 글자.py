def solution(s):
    answer = []
    alphabet = []
    
    for i in range(len(s)):
        if s[i] not in alphabet :
            alphabet.insert(0,s[i])
            answer.append(-1)
        else : 
            answer.append(alphabet.index(s[i])+1)
            alphabet.insert(0,s[i])

    return answer