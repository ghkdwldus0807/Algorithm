def solution(cards1, cards2, goal):
    answer = ''
    cards1_count = 0
    cards2_count = 0
    for i in range (len(goal)):
        if cards1_count<len(cards1) and goal[i] == cards1[cards1_count] :
            cards1_count +=1
            answer = "Yes"
        elif cards2_count<len(cards2) and goal[i] == cards2[cards2_count] :
            cards2_count +=1
            answer = "Yes"
        else:
            answer="No"
            break
            
    return answer