# 1-3. Djikstra 와 좌표평면


만약, 좌표평면에서 구현한다면 어떻게 바뀔까? 좌표로 바꿔서 풀면 된다.  

```py
import sys
import heapq

sys.stdin = open("input.txt", "r")
N, M = map(int, sys.stdin.readline().split())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dist = [[float("inf")] * (M) for _ in range(N)]

dy = (-1, 1, 0, 0)
dx = (0, 0, -1, 1)


def dijkstra(sy, sx):
    hq = []
    heapq.heappush(hq, (0, sy, sx))
    dist[sy][sx] = 0
    while hq:
        cost, cy, cx = heapq.heappop(hq)
        if dist[cy][cx] < cost:
            continue
        for i in range(4):
            ny = cy + dy[i]
            nx = cx + dx[i]
            if ny < 0 or ny >= N or nx < 0 or nx >= M:
                continue
            next_cost = cost + board[ny][nx]
            if next_cost < dist[ny][nx]:
                dist[ny][nx] = next_cost
                heapq.heappush(hq, (next_cost, ny, nx))


dijkstra(0, 0)
```

```
4 4
0 1 3 8
1 2 3 4
2 9 7 5
3 4 6 0
```