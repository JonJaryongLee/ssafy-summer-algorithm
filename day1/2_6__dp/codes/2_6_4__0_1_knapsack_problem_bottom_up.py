n = 4         # 물건의 개수
W = 5         # 배낭의 최대 무게
weights = [2, 3, 4, 5]
values = [3, 4, 5, 6]

# dp[i][w] : 첫 i개의 물건을 고려했을 때, 무게 제한 w에서 얻을 수 있는 최대 가치
dp = [[0] * (W + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for w in range(W + 1):
        if weights[i - 1] > w:
            dp[i][w] = dp[i - 1][w]
        else:
            dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])

print("0/1 Knapsack (Bottom-Up): Maximum value =", dp[n][W])
