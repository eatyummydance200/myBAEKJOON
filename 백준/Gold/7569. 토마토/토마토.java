import java.io.*;
import java.util.*;

enum Tomato {
    EMPTY, RIPE, UNRIPE
}

class Pos {
    public int d, r, c;

    Pos(int d, int r, int c) {
        this.d = d;
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static Tomato[][][] Box;
    static Queue<Pos> q;

    static int totalDays;
    static int M, N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /* < 입력 > ======================================================================*/
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        Box = new Tomato[H][N][M];
        q = new ArrayDeque<>();

        for (int d = 0; d < H; d++) {
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < M; c++) {
                    int input = Integer.parseInt(st.nextToken());

                    if (input == 1) { // 익은 토마토
                        Box[d][r][c] = Tomato.RIPE;
                        q.add(new Pos(d, r, c)); // 익은 토마토에서부터 BFS를 하기 위함
                    } else if (input == 0) // 익지 않은 토마토
                        Box[d][r][c] = Tomato.UNRIPE;
                    else // 토마토가 들어있지 않음
                        Box[d][r][c] = Tomato.EMPTY;
                }
            }
        }

        /* < 로직 > ======================================================================*/
        // 다 익기까지 걸린 시간 == BFS 수행 횟수
        BFS();

        /* < 출력 > ======================================================================*/
        // 토마토가 모두 익었는지
        for (int d = 0; d < H; d++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (Box[d][r][c] == Tomato.UNRIPE) {
                        System.out.println(-1); // 모두 익지 않은 경우
                        return;
                    }
                }
            }
        }
        System.out.println(--totalDays);
    }

    static void BFS() {

        while (!q.isEmpty()) {
            int queueSize = q.size();

            for (int i = 0; i < queueSize; i++) {
                Pos tomato = q.remove();

                int d = tomato.d;
                int r = tomato.r;
                int c = tomato.c;

                Pos[] next = {new Pos(d + 1, r, c), new Pos(d - 1, r, c), // 위 아래
                        new Pos(d, r, c + 1), new Pos(d, r, c - 1), // 동 서
                        new Pos(d, r + 1, c), new Pos(d, r - 1, c), // 남 북
                };

                for (Pos nx : next) {
                    int nD = nx.d;
                    int nR = nx.r;
                    int nC = nx.c;

                    if ((nD < 0 || nD >= H) ||
                            (nR < 0 || nR >= N) ||
                            (nC < 0 || nC >= M)) continue;

                    if (Box[nD][nR][nC] == Tomato.UNRIPE) {
                        q.add(nx);
                        Box[nD][nR][nC] = Tomato.RIPE;
                    }
                }
            }
            totalDays++;
        }
    }

}