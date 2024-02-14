def solution(left, right):
    answer = 0
    number_list = [left+i for i in range (right-left+1)]
    for i in number_list :
        for j in range(1, int(i**0.5)+1) :
            count = 0
            if i%j == 0:
                count += 2
                if i//j==j:
                    count -=1
        if count%2 == 0:
            answer += i
        else :
            answer -= i
    return answer