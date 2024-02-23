from itertools import combinations

def solution(clothes):
    answer = 1
    
    hash_map = {}
    
    for i in clothes:
        item , category = i[0], i[1]
        if category in hash_map:
            hash_map[category] = hash_map.get(category)+1
        else:
            hash_map[category] = 1
    
    num_list = list(hash_map.values())
    
    for i in num_list:
        answer *= (i+1)
    
    answer -= 1

    return answer