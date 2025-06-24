import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE;
    static int N, M;
    static long[] dist;
    static List<Node>[] v;

    public static void main(String[] args) throws IOException {
        // 파일입출력
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        
        // 제출용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N];
        Arrays.fill(dist, INF);

        // 그래프 초기화
        v = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            v[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            v[from].add(new Node(to, cost));
        }
        
        dijkstra(0);
        
        if (dist[N - 1] == INF) {
        	System.out.println("impossible");
        } else {
        	System.out.println(dist[N - 1]);
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int st) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[st] = 0L;
        pq.offer(new Node(st, 0L));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.num]) continue;

            for (Node next : v[cur.num]) {
                long newCost = dist[cur.num] + next.cost;
                if (newCost < dist[next.num]) {
                    dist[next.num] = newCost;
                    pq.offer(new Node(next.num, newCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int num;
        long cost;

        Node(int num, long cost) {
            this.num    = num;
            this.cost   = cost;
        }

        @Override
        public int compareTo(Node other) {
        	return Long.compare(this.cost, other.cost);
        }
    }
}
