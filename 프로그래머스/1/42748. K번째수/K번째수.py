def solution(array, commands):
    answer = []
    
    for row in range(len(commands)) :
        i = commands[row][0]
        j = commands[row][1]
        k = commands[row][2]
        slice = array[i-1:j]
        slice.sort()
        answer.append(slice[k-1])
            
    return answer