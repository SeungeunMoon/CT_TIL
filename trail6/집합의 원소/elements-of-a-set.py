n, m = map(int, input().split())
query = [list(map(int, input().split())) for _ in range(m)]

parent = [i for i in range(0, n+1)]

def main():

    for q in query:
        a = q[1]
        b = q[2]

        if q[0] == 0:
            union(a,b)
        else:
            if(find(a) == find(b)):
                print(1)
            else:
                print(0)

def find(x):
    
    if x != parent[x]:
        parent[x] = find(parent[x])
    
    return parent[x]

def union(a, b):

    x = find(a)
    y = find(b)

    if x == y:
        return
    
    if x < y:
        parent[x] = y
    else:
        parent[y] = x

main()