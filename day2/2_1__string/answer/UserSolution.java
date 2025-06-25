import java.io.*;
import java.util.*;

class UserSolution
{
	ArrayDeque<Character> dq; // 실제 text
	HashMap<String, Integer> cntStr; // 부분 text의 개수
	boolean dir; // 방향 - true : 정방향, false : 역방향 
	
	void update(int oper) { 
		// 문자 1개가 추가 or 삭제 - cntStr을 관리
		// oper - 1 : 추가, -1 : 삭제
		
		String temp = ""; // 부분 문자열
		Iterator<Character> it;
		if(dir)  // 정방향
			it = dq.descendingIterator(); // 뒤에서부터 data를 읽을 준비
		else  // 역방향
			it = dq.iterator(); // 앞에서부터 data를 읽을 준비
		
		int len = Math.min(4, dq.size());
		
		for(int i = 0; i < len; i++) {
			if(dir)
				temp = it.next() + temp; // 방향에 맞는 data(문자)를 추가
			else
				temp = temp + it.next();
			if(!cntStr.containsKey(temp)) // 처음 발견된 부분 문자열
				cntStr.put(temp, 0); // 해당 문자열을 등록
			cntStr.put(temp, cntStr.get(temp) + oper); // 부분문자열 추가 or 삭제
		}
	}
	
	public void init(char[] mainStr)
	{
		dq = new ArrayDeque<>();
		cntStr = new HashMap<>();
		dir = true;
		
		for(int i = 0; i < mainStr.length; i++) {
			char ch = mainStr[i];
			dq.add(ch);
			update(1); // 문자가 1개 추가됐으니 그에 맞게 cntStr을 관리
		}
	}
	
	public void pushBack(char[] newStr)
	{
		for (int i = 0; i < newStr.length; i++) {
			char ch = newStr[i];
			if(dir)
				dq.add(ch);
			else
				dq.addFirst(ch);
			update(1);
		}
	}
	
	public void popBack(int n)
	{
		for(int i = 0; i < n; i++) {
			update(-1); 
			if(dir)
				dq.removeLast();
			else
				dq.removeFirst();
		}
	}
	
	public void reverseStr()
	{
		dir = !dir;
	}
	
	public int getCount(char[] subStr)
	{
		String sub = "";
		if(dir)
			sub = String.valueOf(subStr);
		else {
			for(int i = subStr.length - 1; i >= 0; i--)
				sub += subStr[i];
		}
		
		if(!cntStr.containsKey(sub))
			return 0; // 처음 나온 부분 문자열이면 0
		
		// 일단 존재하면 기록이 됐을 것
		int cnt = cntStr.get(sub);
		return cnt;
	}
}
