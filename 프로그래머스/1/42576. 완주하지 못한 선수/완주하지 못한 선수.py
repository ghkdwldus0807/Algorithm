from collections import Counter 

def solution(participant, completion):
    answer = ''
    part_dict = Counter(participant)
    com_dict = Counter(completion)
    ans_dict = part_dict - com_dict
    
    answer = list(ans_dict.keys())[0]
    
  
            
    return answer