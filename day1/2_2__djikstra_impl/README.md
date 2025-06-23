# 2-3. Djikstra 구현

```py
import sys
import heapq

sys.stdin = open("input.txt", "r")
N, M = map(int, sys.stdin.readline().split())
dist = [float('inf')] * (N + 1)
v = [[] for _ in range(N + 1)]
for _ in range(M):
    from_node, to_node, cost = map(int, sys.stdin.readline().split())
    v[from_node].append((cost, to_node))
    v[to_node].append((cost, from_node))


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


dijkstra(1)
```

```
6 7
1 2 1
1 3 5
2 4 4
2 5 1
3 5 1
4 6 1
5 6 2
```

1. 초기화는 항상 숫자의 최댓값으로 둔다. 파이썬의 경우, `fload('inf')` 상수를 사용할 수 있다.    
2. 방향이 없는 그래프일 경우, 입력이 from -> to 형태로만 주어지는 경우가 많다. 이 경우, 양쪽 다 세팅해줘야 한다.  
3. `cost` 는 항상 맨 앞에 두어야 heapq 에서 `cost` 기준 오름차순 정렬할 수 있다.  
