K, N = map(int, input().split(" "))

picked = []

def pick(depth):

    if depth == N:
        for v in picked:
            print(v, end= " ")
        print()
        return

    for i in range(1,K+1):

        picked.append(i)

        pick(depth+1)

        picked.pop()

pick(0)