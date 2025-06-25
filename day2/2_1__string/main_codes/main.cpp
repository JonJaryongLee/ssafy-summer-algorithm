// ***main.cpp***
#ifndef _CRT_SECURE_NO_WARNINGS
#define _CRT_SECURE_NO_WARNINGS
#endif
 
#include <stdio.h>
 
#define CMD_INIT    1
#define CMD_PUSH    2
#define CMD_POP     3
#define CMD_REVERSE 4
#define CMD_COUNT   5
 
extern void init(char mainStr[]);
extern void pushBack(char newStr[]);
extern void popBack(int n);
extern void reverseStr();
extern int getCount(char subStr[]);
 
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
 
static bool run() {
    bool correct = false;
    int queryCnt;
    scanf("%d", &queryCnt);
    static char mainStr[30001], str[5];
 
    for (int qc = 1; qc <= queryCnt; qc++)
    {
        int cmd;
        scanf("%d", &cmd);
 
        if (cmd == CMD_INIT)
        {
            scanf("%s", mainStr);
            init(mainStr);
            correct = true;
        }
        else if (cmd == CMD_PUSH)
        {
            scanf("%s", str);
 
            if (correct)
                pushBack(str);
        }
        else if (cmd == CMD_POP)
        {
            int n;
            scanf("%d", &n);
 
            if (correct)
                popBack(n);
        }
        else if (cmd == CMD_REVERSE)
        {
            if (correct)
                reverseStr();
        }
        else if (cmd == CMD_COUNT)
        {
            scanf("%s", str);
 
            int ret = -1;
            if (correct)
                ret = getCount(str);
 
            int ans;
            scanf("%d", &ans);
            if (ret != ans)
                correct = false;
        }
    }
    return correct;
}
 
int main()
{
    setbuf(stdout, NULL);
    //freopen("input.txt", "r", stdin);
 
    int T, MARK;
    scanf("%d %d", &T, &MARK);
 
    for (int tc = 1; tc <= T; tc++)
    {
        int score = run() ? MARK : 0;
        printf("#%d %d\n", tc, score);
    }
    return 0;
}
