n = 4
W = 5
weights = [2, 3, 4, 5]
values = [3, 4, 5, 6]

# 메모이제이션을 위한 사전
memo = {}

def knapSack(i, w):
    if i == 0 or w == 0:
        return 0
    if (i, w) in memo:
        return memo[(i, w)]
    if weights[i - 1] > w:
        memo[(i, w)] = knapSack(i - 1, w)
    else:
        memo[(i, w)] = max(knapSack(i - 1, w),
                            knapSack(i - 1, w - weights[i - 1]) + values[i - 1])
    return memo[(i, w)]

print("0/1 Knapsack (Top-Down): Maximum value =", knapSack(n, W))
