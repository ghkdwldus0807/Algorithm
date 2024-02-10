def solution(absolutes, signs):
    answer = 123456789
    ans_list = [absolutes[i] if signs[i]==True else -absolutes[i] for i in range (len(absolutes))]
    answer = sum(ans_list)
    return answer