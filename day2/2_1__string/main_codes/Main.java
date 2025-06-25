import java.io.*;
import java.util.*;

class Main {

	private final static int CMD_INIT = 1;
	private final static int CMD_PUSH = 2;
	private final static int CMD_POP = 3;
	private final static int CMD_REVERSE = 4;
	private final static int CMD_COUNT = 5;

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	private final static UserSolution usersolution = new UserSolution();

	private static boolean run() throws Exception {
		
		boolean correct = false;
		int queryCnt;
		int ans;
		int userAns; 
	
		st = new StringTokenizer(br.readLine());
		queryCnt = Integer.parseInt(st.nextToken()); 

		for (int qc = 1; qc <= queryCnt; qc++) {

			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == CMD_INIT) 
			{
				char[] mainStr = st.nextToken().toCharArray();
				usersolution.init(mainStr);
				correct = true;
			}
			else if (cmd == CMD_PUSH) 
			{
				char[] str = st.nextToken().toCharArray();
				usersolution.pushBack(str);
			}
			else if (cmd == CMD_POP) 
			{
				int n = Integer.parseInt(st.nextToken());
				usersolution.popBack(n);
			}
			else if (cmd == CMD_REVERSE) 
			{
				usersolution.reverseStr();
			}
			else if (cmd == CMD_COUNT) 
			{
				char[] str = st.nextToken().toCharArray();
				userAns = usersolution.getCount(str);
				ans = Integer.parseInt(st.nextToken());
				if (userAns != ans)
					correct = false;
			}
		}
		return correct;
	}

	public static void main(String[] args) throws Exception {
		int T, MARK;

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		MARK = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			int score = run() ? MARK : 0;
			System.out.println("#" + tc + " " + score);
		}
		br.close();
	}
}
