def fib(n):
    # 재귀 함수로 피보나치 수 계산
    if n <= 1:
        return n
    return fib(n - 1) + fib(n - 2)


n = 10  # 출력할 피보나치 수열의 항 수
sequence = [fib(i) for i in range(1, 11)]
print("Fibonacci Sequence:", sequence)