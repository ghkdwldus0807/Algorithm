def solution(n):
    answer = 0
    str_n = str(n)
    ans_list = [i for i in str_n]
    ans_list.sort(reverse=True)
    sorted_str = ''.join(ans_list)
    answer = int(sorted_str)
        
    return answer