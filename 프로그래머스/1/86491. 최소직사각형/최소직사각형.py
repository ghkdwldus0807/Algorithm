def solution(sizes):
    answer = 0
    w = [i[0] for i in sizes]
    h = [i[1] for i in sizes]
    
    for i in range(0,len(w)):
        if w[i]<h[i]:
            w[i],h[i] = h[i],w[i]
            
    answer = max(w) * max(h)
    return answer