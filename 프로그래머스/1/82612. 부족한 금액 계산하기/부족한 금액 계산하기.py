def solution(price, money, count):
    answer = -1
    charge = sum(i*price for i in range (1,count+1))
    
    if money-charge > 0 :
        answer = 0
    else :
        answer = charge - money

    return answer