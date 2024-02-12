def solution(numbers):
    numbers = set(numbers)
    all_num = {0,1,2,3,4,5,6,7,8,9}
    ans_set = all_num - numbers
    answer = sum(ans_set)
    return answer