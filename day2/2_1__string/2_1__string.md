# 2-1. 문자열 관리 프로그램

문자열을 관리해주는 프로그램으로 다음과 같은 기능을 구성하고자 합니다.  

1. 관리하는 문자열의 뒤에 특정 문자열 추가  
2. 관리하는 문자열의 뒤에서 특정 개수의 문자 제거  
3. 관리하는 문자열을 뒤집음  
4. 관리하는 문자열 내 특정 문자열의 개수 확인  

위와 같이 문자열을 완벽하게 관리하는 프로그램을 작성하세요.  

**입력**  
입출력은 제공되는 Main 부분의 코드에서 처리하므로 User Code 부분의 코드에서는 별도로 입출력을 처리하지 않는다.  

**출력**  
Sample input 에 대한 정답 출력 결과는 “#TC번호 결과” 의 포맷으로 보여지며 결과가 100 일 경우 정답, 0 일 경우 오답을 의미한다.  

**API 설명**  

```cpp
// c++
void init(char mainStr[])
```
```java
// java
public void init(char[] mainStr)
```
```py
# python
def init(mStr : str)
```

각 테스트 케이스의 처음에 한번 호출된다.  
- 초기 문자열로 mainStr이 주어진다.  


Parameters
- mainStr : 초기 문자열 (소문자, 길이 1~30,000)  

---

```cpp
// cpp
void pushBack(char newStr[])
```
```java
// java
public void pushBack(char[] newStr)
```
```py
# python
def pushBack(mWord : str)
```

mainStr 맨 뒤에 newStr 문자열을 추가한다.  


Parameters  
- newStr : 끝에 붙일 문자열 (소문자, 길이 1~4)

---

```cpp
// cpp
void popBack(int n)
```
```java
// java
public void popBack(int n)
```

```py
# python
def popBack(k : int)
```

mainStr 맨 뒤에 n개의 문자를 제거한다.  
n은 호출 시점의 mainStr 길이보다 작음이 보장된다.  

Parameters  
- n : 제거할 문자의 개수 ( 1 ≤ n < 문자열 길이)  

---

```cpp
// cpp
void reverseStr()
```
```java
// java
public void reverseStr()
```
```py
# python
def reverseStr()
```

mainStr을 뒤집는다.  

---

```cpp
// cpp
int getCount(char subStr[])
```
```java
// java
public int getCount(char[] subStr)
```
```py
# python
def getCount(mWord : str) -> int
```

mainStr에서 subStr이 등장하는 횟수를 반환한다.  
- 문자열이 겹치는 경우도 중복해서 센다.  
- 예를 들어서 "aaa"에서 "aa"의 등장 횟수는 2회이다.  
- mainStr을 전체 탐색하면 시간 초과가 발생할 수 있다.   


Parameters  
- subStr : 등장 횟수를 세기 위한 문자열 (소문자, 길이 1~4)  


Returns  
- mainStr에서 subStr 등장 횟수 반환  


**제약사항**
1. 각 테스트 케이스 시작 시 init() 함수가 호출된다.  
2. 각 테스트 케이스에서 pushBack() 함수의 호출 횟수는 30,000 이하이다.  
3. 각 테스트 케이스에서 popBack() 함수의 호출 횟수는 100 이하이다.  
4. 각 테스트 케이스에서 reverseStr() 함수의 호출 횟수는 30,000 이하이다.  
5. 각 테스트 케이스에서 getCount() 함수의 호출 횟수는 30,000 이하이다.  
