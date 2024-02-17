def solution(s):
    answer = 0
    eng =['zero','one','two','three','four','five','six','seven','eight','nine']
    word = ''
    answer_s = ''
    for i in range (len(s)):
       
        try :
            int(s[i])
        except ValueError:
            word += s[i]
            if word in eng :
                answer_s += str(eng.index(word))
                word = ''
            else :
                continue
        else :
            answer_s += s[i]
        
    answer = int(answer_s)
    return answer