# Top-Down
def fib(n):
    # 이미 계산한 값이 있으면 바로 반환
    if n in dp:
        return dp[n]
    if n <= 1:
        return n
    dp[n] = fib(n - 1) + fib(n - 2)
    return dp[n]


# 피보나치 수열 항의 개수
n = 10
# dp 사전 초기화: 아직 계산하지 않은 값들을 저장할 딕셔너리
dp = {}

sequence = [fib(i) for i in range(1, n + 1)]
print("Fibonacci Sequence:", sequence)