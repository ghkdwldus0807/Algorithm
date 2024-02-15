def solution(s):
    answer = ''
    arr = s.split(" ")
    new_arr=[]
    
    for word in arr :
        new_word = ''
        for i in range (0,len(word)):
            if i%2 == 0 or i==0: 
                new_word+=word[i].upper()
            else :
                new_word+=word[i].lower()
        new_arr.append(new_word)
                

    answer = " ".join(new_arr)
    return answer