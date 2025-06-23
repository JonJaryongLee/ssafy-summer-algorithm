from functools import lru_cache

def lcs_top_down(s1, s2):
    @lru_cache(maxsize=None)
    def helper(i, j):
        if i == len(s1) or j == len(s2):
            return 0
        if s1[i] == s2[j]:
            return 1 + helper(i + 1, j + 1)
        else:
            return max(helper(i + 1, j), helper(i, j + 1))
    return helper(0, 0)

s1 = "ABCBDAB"
s2 = "BDCAB"
print("LCS (Top-Down): Length =", lcs_top_down(s1, s2))
