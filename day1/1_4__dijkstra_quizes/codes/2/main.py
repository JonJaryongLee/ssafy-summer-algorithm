import sys
import heapq

# sys.stdin = open("input.txt", "r")
N, M = map(int, sys.stdin.readline().split())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dist = [[float("inf")] * (M) for _ in range(N)]

dy = (-1, 1, 0, 0)
dx = (0, 0, -1, 1)


def dijkstra(sy, sx):
    hq = []
    heapq.heappush(hq, (board[sy][sx], sy, sx))
    dist[sy][sx] = board[sy][sx]
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

print(dist[N - 1][M - 1])
