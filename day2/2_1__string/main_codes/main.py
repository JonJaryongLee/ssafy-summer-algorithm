'''
main.py
'''
import sys
from solution import init, pushBack, popBack, reverseStr, getCount
 
 
CMD_INIT    = 1
CMD_APPEND  = 2
CMD_popBack      = 3
CMD_reverseStr  = 4
CMD_COUNT    = 5
 
 
def run():
    query_cnt = int(sys.stdin.readline())
    correct = False
 
    for q in range(query_cnt):
        inputs = iter(sys.stdin.readline().split())
        cmd = int(next(inputs))
 
        if cmd == CMD_INIT:
            mStr = next(inputs)
            init(mStr)
            correct = True
 
        elif cmd == CMD_APPEND:
            mWord = next(inputs)
            if correct:
                pushBack(mWord)
 
        elif cmd == CMD_popBack:
            k = int(next(inputs))
            if correct:
                popBack(k)
 
        elif cmd == CMD_reverseStr:
            if correct:
                reverseStr()
 
        elif cmd == CMD_COUNT:
            mWord = next(inputs)
            ret = -1
            if correct:
                ret = getCount(mWord)
           
            ans = int(next(inputs))
            if ret != ans:
                correct = False
 
    return correct
 
 
def main():
    # sys.stdin = open('sample_input.txt', 'r')
    TC, MARK = map(int, sys.stdin.readline().split())
 
    for testcase in range(1, TC + 1):
        score = MARK if run() else 0
        print("#%d %d" % (testcase, score), flush = True)
 
 
if __name__ == '__main__':
    main()
