def solution(nums):
    answer = 0
    choice = len(nums)//2
    nums = set(nums)
    
    if len(nums) > choice :
        answer = choice
    else : 
        answer = len(nums)
    return answer