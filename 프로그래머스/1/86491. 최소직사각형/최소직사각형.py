def solution(sizes):
    answer = 0
    w = [i[0] for i in sizes]
    h = [i[1] for i in sizes]
    
    for i in range(0,len(w)):
        diff_w = max(w) - w[i]
        diff_h = max(h) - h[i]
        
        if max(w) - h[i] < diff_w :
            w[i],h[i] = h[i],w[i]
        elif w[i] == max(w) :
            continue
    
    answer = max(w)*max(h)
    return answer