def solution(phone_book):
    answer = True
    
    hash_map = {}
    
    for i in phone_book:
        hash_map[i] = 1
    
    for i in phone_book:
        num = ''
        for j in i:
            num += j
            if num in hash_map and num != i :
                answer = False
                break
    
    
    return answer