def solution(n, arr1, arr2):
    answer = []
    answer = [bin(arr1[i]|arr2[i]) for i in range (n)]
    answer = list(map(lambda x: x[2:],answer))
    answer = [answer[i].replace("1","#") for i in range(n)]
    answer = [answer[i].replace("0"," ") for i in range(n)]
    answer = [" "*(n-len(answer[i])) + answer[i] if len(answer[i])<n else answer[i] for i in range(n)]
    return answer