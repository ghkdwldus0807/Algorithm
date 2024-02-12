def solution(phone_number):
    answer = ''
    last = phone_number[-4:]
    answer = '*'*(len(phone_number)-4)+last
    return answer