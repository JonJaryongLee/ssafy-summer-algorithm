import sys
import heapq

# sys.stdin = open("input.txt", "r")
N, M = map(int, sys.stdin.readline().split())
dist = [float('inf')] * (N + 1)
v = [[] for _ in range(N + 1)]
for _ in range(M):
    from_node, to_node, cost = map(int, sys.stdin.readline().split())
    v[from_node].append((cost, to_node))


def dijkstra(st):
    hq = []
    heapq.heappush(hq, (0, st))
    dist[st] = 0
    while hq:
        cost, num = heapq.heappop(hq)
        if dist[num] < cost:
            continue
        for next_cost, next_num in v[num]:
            next_cost = cost + next_cost
            if next_cost < dist[next_num]:
                dist[next_num] = next_cost
                heapq.heappush(hq, (next_cost, next_num))

dijkstra(0)

if dist[N - 1] == float('inf'):
    print("impossible")
else:
    print(dist[N - 1])
