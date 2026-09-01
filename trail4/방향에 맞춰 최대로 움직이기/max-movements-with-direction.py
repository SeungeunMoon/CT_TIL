from collections import deque

n = int(input())
num = [list(map(int, input().split())) for _ in range(n)]
move_dir = [list(map(int, input().split())) for _ in range(n)]
r, c = map(int, input().split())

dr, dc = [0, -1, -1, 0, 1, 1, 1, 0, -1], [0, 0, 1, 1, 1, 0, -1, -1, -1]
visited = [[False]*n for _ in range(n)]

class Point:
    def __init__(self, r, c, length):
        self.r = r
        self.c = c
        self.length = length

def bfs(r, c):
    maxAns = 0
    q = deque([Point(r, c, 0)])

    while q:
        cur = q.popleft()
        maxAns = max(maxAns, cur.length)
        dir = move_dir[cur.r][cur.c]
        nr, nc = cur.r + dr[dir], cur.c+ dc[dir]

        while (nr>=0 and nc>=0 and nr < n and nc < n):
            
            if(num[cur.r][cur.c] < num [nr][nc]):
                q.append(Point(nr, nc, cur.length+1))
            nr += dr[dir]
            nc += dc[dir]
    

    return maxAns

answer = bfs(r-1, c-1)
print(answer)


