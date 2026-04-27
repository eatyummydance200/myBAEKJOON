import java.io.*;
import java.util.*;

// 토마토의 상태
enum State {
    WALL, CLEAN, UNCLEAN
}

enum Dir {
    UP(0), DOWN(2), RIGHT(1), LEFT(3);

    private Dir nextDir;
    public int index;

    static {
        UP.nextDir = LEFT;
        DOWN.nextDir = RIGHT;
        RIGHT.nextDir = UP;
        LEFT.nextDir = DOWN;
    }

    Dir(int index) {
        this.index = index;
    }

    public static Dir getDir(int num) {
        for (Dir d : Dir.values())
            if (d.index == num)
                return d;
        return UP;
    }

    public Dir turn() {
        return this.nextDir;
    }

    public Dir back() {
        return this.nextDir.nextDir;
    }
}

class Pos {
    public int r, c;

    Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public boolean isValid() {
        if (0 <= this.r && this.r < Main.N &&
                0 <= this.c && this.c < Main.M &&
                Main.room[this.r][this.c] != State.WALL)
            return true;
        else
            return false;
    }
}

public class Main {
    static State[][] room;

    static int M, N;
    static int cleanedCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        /* < 입력 > ======================================================================*/
        // N,M
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new State[N][M];

        // 로봇 청소기 입력
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 방향

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());

                if (input == 1) // 벽
                    room[i][j] = State.WALL;
                else
                    room[i][j] = State.UNCLEAN;
            }
        }

        /* < 로직 > ======================================================================*/
        cleanedCnt = 0;
        Dir dir = Dir.getDir(d);
        run(r, c, dir);

        /* < 출력 > ======================================================================*/

        System.out.println(cleanedCnt);
    }

    static void run(int r, int c, Dir d) {
        boolean isRunning = true;

        while (isRunning) {
            /*
                1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            */
            if (room[r][c] == State.UNCLEAN) {
                room[r][c] = State.CLEAN;
                cleanedCnt++;
            }

            Pos[] nexts = new Pos[4];

            nexts[Dir.UP.index] = new Pos(r - 1, c); // 위
            nexts[Dir.DOWN.index] = new Pos(r + 1, c); // 아래
            nexts[Dir.RIGHT.index] = new Pos(r, c + 1); // 오른쪽
            nexts[Dir.LEFT.index] = new Pos(r, c - 1); // 왼쪽

            boolean isCleanable = false;

            for (Pos next : nexts) {
                if (room[next.r][next.c] == State.UNCLEAN) { // 청소되지 않은 빈 칸이 있다면
                    isCleanable = true;
                    break;
                }
            }

            /*
                2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
                    1) 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                    2) 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            */
            if (!isCleanable) { // 청소 불가능한 상황
                Pos next = nexts[d.back().index]; // 후진한 위치

                if (next.isValid()) { // 후진할 수 있다면
                    r = next.r;
                    c = next.c;
                } else { // 후진할 수 없다면
                    isRunning = false; // 작동 중지
                }
            }

            /*
                3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
                    1) 반시계 방향으로 90도 회전한다.
                    2) 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                    3) 1번으로 돌아간다.
            */
            else { // 청소 가능한 상황
                d = d.turn(); // 1) 회전

                Pos next = nexts[d.index];
                if (next.isValid() && room[next.r][next.c] == State.UNCLEAN) { // 2) 빈 칸이면 전진
                    r = next.r;
                    c = next.c;
                }
            }
        }
    }
}
