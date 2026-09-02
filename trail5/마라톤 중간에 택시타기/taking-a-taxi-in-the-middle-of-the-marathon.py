import math

n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

def distance(x1,x2,y1,y2):
    return abs(x1-x2) + abs(y1-y2)

minDistance = math.inf

L = [0 for _ in range(n)]
R = [0 for _ in range(n)]

for i in range(1, n):
    L[i] += (L[i-1] + distance(x[i-1],x[i], y[i-1],y[i]))

for i in range(n-1,1,-1):
    R[i-1] += (R[i] + distance(x[i-1],x[i],y[i-1],y[i]))

for i in range(1, n-1):
    minDistance = min(minDistance, L[i-1] + R[i+1] + distance(x[i-1],x[i+1],y[i-1],y[i+1]))

print(minDistance)

