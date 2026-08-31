n, m, c = map(int, input().split())
weight = [list(map(int, input().split())) for _ in range(n)]

def getMaxWeights(i,j):
    totalMax = 0

    def dfs(idx, totalWeight, totalValue):
        nonlocal totalMax

        if(totalWeight > c):
            return
        
        if idx == m:
            totalMax = max(totalMax, totalValue)
            return
        
        dfs(idx + 1, totalWeight + weight[i][j+idx] , totalValue + weight[i][j+idx] ** 2 )

        dfs(idx + 1, totalWeight, totalValue)

    dfs(0,0,0)

    return totalMax

# m 간격의 경우의 수 모두 생성
# [행, 시작열]
cases = []
for i in range(n):
    for j in range(n-m+1):
        cases.append([i,j])

# 미리 구간마다 최대 무게 계산
maxWeights = []
for (i,j) in cases:
    maxWeights.append(getMaxWeights(i,j))

answer = 0
for i in range(len(cases)):
    for j in range(i,len(cases)):
            if (cases[i][0] == cases[j][0]) and (cases[i][1] + m) > cases[j][1]:
                continue
            answer = max(answer, maxWeights[i] + maxWeights[j])
            
print(answer)

