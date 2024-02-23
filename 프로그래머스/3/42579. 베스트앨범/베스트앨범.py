def solution(genres, plays):
    answer = []
    
    sum_hash={}
    
    for i in range (len(genres)):
        if genres[i] in sum_hash:
            sum_hash[genres[i]] = sum_hash.get(genres[i]) + plays[i]
        else :
            sum_hash[genres[i]] = plays[i]
            
    sum_hash = dict(sorted(sum_hash.items(),key=lambda x: x[1],reverse = True))
    
    arr = []
    
    for i,(genre,play) in enumerate (zip(genres, plays)):
        arr.append([i,genre,play])
    sorted_arr = sorted(arr,key=lambda x:x[2],reverse=True)
    
    print(sum_hash)
    print(sorted_arr)
    
    for genre in sum_hash:
        count = 0 
        for i in sorted_arr : 
            if count==2:
                break
            if genre == i[1] :
                answer.append(i[0])
                count +=1
    return answer