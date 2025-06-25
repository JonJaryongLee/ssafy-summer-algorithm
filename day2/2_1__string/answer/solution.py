from collections import deque
dq = deque()
dic = {}
dir = 0; 

def update(cnt):
    global dq
    global dic
    
    s = ""
    max_len = min(len(dq), 4)
    
    if dir == 0:
        for i in range(max_len):
            s = dq[-1 -i] + s
            if s not in dic:
                dic[s] = 0
            dic[s] += cnt
    elif dir == 1:
        for i in range(max_len):
            s = s + dq[i]
            if s not in dic:
                dic[s] = 0
            dic[s] += cnt

def init(mStr : str):
    global dq, dic, dir
    
    dq = deque()
    dic = {}
    dir = 0
    for ltr in mStr:
        dq.append(ltr)
        update(1)

def pushBack(mWord : str):
    global dq
    if dir == 0:
        for ltr in mWord:
            dq.append(ltr)
            update(1)
    else:
        for ltr in mWord:
            dq.appendleft(ltr)
            update(1)
 
def popBack(k : int):
    global dq
    if dir == 0:
        for i in range(k):
            update(-1)
            dq.pop()
    else:
        for i in range(k):
            update(-1)
            dq.popleft()
 
def reverseStr():
    global dir
    dir = (dir + 1) % 2 
 
def getCount(mWord : str) -> int:
    s = ""
    if dir == 0:
        s = mWord
    else:
        s = mWord[::-1]
    if s not in dic.keys():
        return 0
    return dic[s]
