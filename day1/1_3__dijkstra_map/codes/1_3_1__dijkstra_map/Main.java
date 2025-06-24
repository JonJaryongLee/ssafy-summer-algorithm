import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static long[][] dist;
    static final long INF = Long.MAX_VALUE;
    // 상하좌우
    static final int[] dy = { -1, 1, 0, 0 };
    static final int[] dx = {  0, 0, -1, 1 };
    
    public static void main(String[] args) throws IOException {
        // 파일입출력
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        
        // 제출용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dist = new long[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }

        dijkstra(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int sy, int sx) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[sy][sx] = 0;
        pq.offer(new Node(sy, sx, 0L));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.y][cur.x]) continue;

            for (int dir = 0; dir < 4; dir++) {
                int ny = cur.y + dy[dir];
                int nx = cur.x + dx[dir];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                long nextCost = cur.cost + board[ny][nx];
                if (nextCost < dist[ny][nx]) {
                    dist[ny][nx] = nextCost;
                    pq.offer(new Node(ny, nx, nextCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int y, x;
        long cost;

        Node(int y, int x, long cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }
}
