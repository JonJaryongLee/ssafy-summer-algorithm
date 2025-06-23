#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <vector>
#include <climits>

using namespace std;

struct Edge
{
    int y;
    int x;
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
int MAP[100][100];
long long dist[100][100];
int dy[4] = {-1, 1, 0, 0};
int dx[4] = {0, 0, -1, 1};

void dijkstra(int sy, int sx)
{
    priority_queue<Edge, vector<Edge>, cmp> pq;
    pq.push({sy, sx, MAP[sy][sx]});
    dist[sy][sx] = MAP[sy][sx];
    while (!pq.empty())
    {
        Edge now = pq.top();
        pq.pop();

        if (dist[now.y][now.x] < now.cost)
        {
            continue;
        }

        for (int i = 0; i < 4; i++)
        {
            int ny = now.y + dy[i];
            int nx = now.x + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
            {
                continue;
            }
            long long nextCost = now.cost + MAP[ny][nx];
            if (nextCost < dist[ny][nx])
            {
                dist[ny][nx] = nextCost;
                pq.push({ny, nx, nextCost});
            }
        }
    }
}

int main()
{
    // freopen("sample_input.txt", "r", stdin);

    cin >> N >> M;

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> MAP[i][j];
        }
    }

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            dist[i][j] = LLONG_MAX;
        }
    }

    dijkstra(0, 0);

    cout << dist[N - 1][M - 1];
}