from collections import Counter 

def solution(participant, completion):
    answer = ''
    part_dict = Counter(participant)
    com_dict = Counter(completion)
    ans_dict = part_dict - com_dict
    
    for i in ans_dict :
        if ans_dict[i] == 1:
            answer = i
            break
            
    return answer