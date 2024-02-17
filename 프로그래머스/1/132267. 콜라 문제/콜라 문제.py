def solution(a, b, n):
    answer = 0
    
    while (n>=a):
        answer += (n//a)*b
        n = (n//a)*b + n%a 
    return answer
#트에 주어야 하는 병 수 a, 빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b, 상빈이가 가지고 있는 빈 병의 개수 n