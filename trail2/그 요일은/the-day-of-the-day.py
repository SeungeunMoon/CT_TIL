m1, d1, m2, d2 = map(int, input().split())
A = input()

days = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri','Sat','Sun']
idx = 0
for i in range(7):
    if days[i] == A:
        idx = i

th = [1,3,5,7,8,10,12]
tho = [4,6,9,11]
feb = 2
day = 0

if(m1 == m2):
    day = (d2 - d1)

else:

    for i in range(m1, m2):
        if i in th:
            val = 31
        elif i == feb:
            val = 29
        else:
            val = 30
        
        if m1 == i:
            day += (val - d1)
        else:
            day += val

    day += d2

# 몫은 default
# 나머지 인덱스만큼 +1

answer = day // 7
left = day % 7
if (idx <= left):
    answer+=1

print(answer)



