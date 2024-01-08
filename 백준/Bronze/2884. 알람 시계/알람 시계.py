h, m = map(int, input().split())

h_to_m = h * 60
total_m = h_to_m + m
alarm = total_m - 45

if h == 0 and 0 <= m <= 44:
    alarm_h = 23

else:
    alarm_h = int(alarm / 60)

alarm_m = alarm % 60

print(alarm_h, alarm_m)
