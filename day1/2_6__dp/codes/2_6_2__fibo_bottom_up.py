n = 10  # 피보나치 수열 항의 개수
dp = [0] * (n + 1)

# 초기 값 설정
dp[0] = 0
dp[1] = 1
dp[2] = 1

# Bottom-Up
for i in range(3, n + 1):
    dp[i] = dp[i - 1] + dp[i - 2]

sequence = [dp[i] for i in range(1, n + 1)]
print("Fibonacci Sequence:", sequence)
