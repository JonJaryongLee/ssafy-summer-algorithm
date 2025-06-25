#include<iostream>
#include<string>
#include<deque>
#include<unordered_map>
#include<algorithm>
using namespace std;

deque<char> str;
int dir;
unordered_map<string, int> cntStr;

void push(char ch) {
	string temp = "";
	if (!dir) {
		str.push_back(ch);
		for (int i = str.size() - 1; i >= max(0, (int)str.size() - 4); i--) {
			temp = str[i] + temp;
			cntStr[temp]++;
		}
	}
	else {
		str.push_front(ch);
		for (int i = 0; i < min((int)str.size(), 4); i++) {
			temp = temp + str[i];
			cntStr[temp]++;
		}
	}
}

void pop() {
	string temp = "";
	if (!dir) {
		for (int i = str.size() - 1; i >= 0 && i >= str.size() - 4; i--) {
			temp = str[i] + temp;
			cntStr[temp]--;
		}
		str.pop_back();
	}
	else {
		for (int i = 0; i < str.size() && i < 4; i++) {
			temp = temp + str[i];
			cntStr[temp]--;
		}
		str.pop_front();
	}
}

// ***user.cpp***
void init(char mainStr[]) {
	str.clear();
	dir = 0;
	cntStr.clear();
	for (int i = 0; mainStr[i]; i++)
		push(mainStr[i]);
}

void pushBack(char newStr[]) {
	for (int i = 0; newStr[i]; i++)
		push(newStr[i]);
}

void popBack(int n) {
	for(int i = 0; i < n; i++)
		pop();
}

void reverseStr() {
	dir = !dir;
}

int getCount(char subStr[]) {
	string temp = subStr;
	if (dir)
		reverse(temp.begin(), temp.end());
	return cntStr[temp];
}
