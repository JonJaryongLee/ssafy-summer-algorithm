#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

struct Edge
{
    int num;
    long long cost;
};

struct cmp
{
    bool operator()(Edge a, Edge b)
    {
        return a.cost > b.cost;
    }
};

int N, M;
long long dist[20001];
vector<Edge> v[20001];

void dijkstra(int st)
{
    priority_queue<Edge, vector<Edge>, cmp> pq;
    pq.push({ st, 0 });
    dist[st] = 0;
    while (!pq.empty())
    {
        Edge now = pq.top();
        pq.pop();

        // 가지치기 조건
        if (dist[now.num] < now.cost)
            continue;

        for (int i = 0; i < v[now.num].size(); i++)
        {
            long long nextCost = now.cost + v[now.num][i].cost;

            int tar = v[now.num][i].num;
            if (nextCost < dist[tar])
            {
                dist[tar] = nextCost;
                pq.push({ tar, nextCost });
            }
        }
    }
}

int main()
{
    // freopen("input.txt", "r", stdin);
    cin >> N >> M;
    int from, to;
    long long cost;
    for (int i = 0; i < M; i++)
    {
        cin >> from >> to >> cost;
        v[from].push_back({ to, cost });
    }

    // 초기 dist 세팅
    for (int i = 1; i <= N; i++)
    {
        dist[i] = LLONG_MAX;
    }

    dijkstra(0);

    if (dist[N - 1] == LLONG_MAX) {
      cout << "impossible\n";
    } else {
      cout << dist[N - 1] << "\n";
    }
}
