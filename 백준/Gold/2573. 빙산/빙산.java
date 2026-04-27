import java.io.*;
import java.util.*;

class Pos {
    public int r, c;

    Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public boolean isValid() {
        return (this.r >= 0 && this.r < Main.N &&
                this.c >= 0 && c < Main.M);
    }
}

public class Main {
    static int N, M;
    static int calvingTime;

    static int[][] icebergMap;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /* < 입력 > */
        // N : 행
        // M : 열
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        icebergMap = new int[N][M];
        // map 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());

                icebergMap[i][j] = input;
            }
        }
        /* < 로직 > */
        calvingTime = 0;

        while (true) {
            // 다 녹을 때까지 분리되지 않은 경우 확인
            if (isMelted()) {
                calvingTime = 0; // 0으로 출력
                break;
            }

            // 두 덩이로 분리되었는지 확인하기
            if (isTwoIceberg()) {
                break;
            }

            // 빙하 녹기
            melt();

            calvingTime++;
        }

        /* < 출력 > */
        System.out.println(calvingTime);
    }

    static boolean isMelted() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (icebergMap[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    static boolean isTwoIceberg() {
        visited = new boolean[N][M];
        int BFSCnt = 0; // 몇 덩이 == BFS 수행 횟수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (icebergMap[i][j] != 0 && !visited[i][j]) { // 바다인 부분은 제외
                    BFS(new Pos(i, j));
                    BFSCnt++;
                }
            }
        }
        return BFSCnt > 1; // 두 덩이로 나뉘었으면 true, 한 덩이면 false
    }

    static void melt() {
        int[][] temp = Arrays.stream(icebergMap)
                .map(int[]::clone)
                .toArray(int[][]::new);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) continue; // 바다인 부분은 제외

                // 위 아래 좌 우
                Pos[] cells = {new Pos(i - 1, j), new Pos(i + 1, j), new Pos(i, j - 1), new Pos(i, j + 1)};

                // 주변에 바닷물이 있는지 조사
                for (Pos cell : cells) {
                    if (!cell.isValid()) continue; // 유효하지 않다면 패스하기

                    if (temp[cell.r][cell.c] == 0) {
                        icebergMap[i][j]--; // 바닷물이면 빙하 녹기
                    }
                }

                // 0보다 더 녹을 수 없으므로 0으로 처리
                if (icebergMap[i][j] < 0) icebergMap[i][j] = 0;
            }
        }
    }

    static void BFS(Pos start) {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            Pos node = q.remove();

            int r = node.r;
            int c = node.c;

            if (!node.isValid()) continue; // 유효성 검사
            if (visited[r][c] || icebergMap[r][c] == 0) continue; // 이미 방문 or 바다인 경우 제외

            visited[r][c] = true;

            q.add(new Pos(r - 1, c)); // UP
            q.add(new Pos(r + 1, c)); // DOWN
            q.add(new Pos(r, c + 1)); // RIGHT
            q.add(new Pos(r, c - 1)); // LEFT
        }
    }
}
