
def solution(n, m):
    answer = []
    gcd = 0
    a = n
    b = m
    
    while b!=0 :
        a, b = b, a%b
    
    gcd = a
    answer.append(a)
    lcm = n*m//gcd
    answer.append(lcm)
    return answer