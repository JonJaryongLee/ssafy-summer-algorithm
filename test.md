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

위 파이썬 코드를 자바 코드로 변경하되, 다음 원칙에 따라줘.

1. 백준 같은 알고리즘 사이트에서 중요하게 고려하는 시간복잡도, 공간복잡도를 중요하게 고려해줘. 정적 배열로 충분한데 ArrayList 를 쓴다던가 하면 시간 초과가 발생하는 경우가 있기에, 구현을 위한 적절한 자료구조를 사용해주고, 배열 사이즈를 지나치게 크게 선언하지도 말아줘. input / output 에서 최적의 시간을 낼 수 있도록 작성해줘.
2. 변수명 / 함수명은 snake_case 가 아닌 camelCase 로 작성하고, 클래스는 PascalCase 로 작성해서 자바 원칙에 따라줘. 단, 변수명 / 함수명을 위 명시된 것 이외의 것으로 함부로 변경하진 말아줘.
3. 자바엔 튜플이 없으므로 클래스에서 `__lt__` 메서드를 사용해 cost 오름차순 정렬이 유지되도록 Priority_Queue 를 사용해줘.
4. 메인함수가 포함된 클래스명은 `Solution` 으로 지정하고, 파일을 여러 개 분리하지 말고 단일 파일로만 작성해줘.