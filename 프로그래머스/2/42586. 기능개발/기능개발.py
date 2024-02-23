def solution(progresses, speeds):
    answer = []
    pro = list(100-i for i in progresses)
    pro = list(pro[i]//speeds[i] if pro[i]%speeds[i]==0 
              else pro[i]//speeds[i] + 1 for i in range(len(pro)))
    print(pro)
    
    count = 1
    compare = pro[0]
    for i in range(1,len(pro)):
        if compare >= pro[i] :
            count+=1 
        else :
            answer.append(count)
            count = 1
            compare = pro[i]
    answer.append(count)
    return answer