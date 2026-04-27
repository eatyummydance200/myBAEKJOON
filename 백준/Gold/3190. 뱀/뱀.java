import java.io.*;
import java.util.*;

class Snake{
    private class Pos{
        int x;
        int y;
        Pos(int y, int x){
            this.y = y; this.x = x;
        }
        
        Pos(Pos Other) {
            this.x = Other.x;
            this.y = Other.y;
        }
    }
    private int size;
    private Deque<Pos> cells; // 몸통들의 위치
    public boolean isAlive = true;

    // 방향 자료형 
    // RIGHT, DOWN, LEFT, UP
    private enum Dir {
        UP, RIGHT, DOWN, LEFT;

        private Dir next;
        private Dir prev;

        // static block을 통해 enum 상수가 생성된 후 서로 연결해줍니다.
        static {
            UP.next = RIGHT; UP.prev = LEFT;
            RIGHT.next = DOWN; RIGHT.prev = UP;
            DOWN.next = LEFT; DOWN.prev = RIGHT;
            LEFT.next = UP; LEFT.prev = DOWN;
        }

        public Dir turnRight() { return this.next; }
        public Dir turnLeft() { return this.prev; }
    }

    private Dir head_dir;

    Snake(){ 
        cells = new ArrayDeque<>();
        cells.addFirst(new Pos(1,1)); // 초기 위치: (1,1)
        Main.board[1][1] = Obj.SNAKE;
        head_dir = Dir.RIGHT; // 초기 방향: 오른쪽
        size = 1;
    }

    Pos getNextPos(){
        Pos now = new Pos(
                cells.getFirst().y,
                cells.getFirst().x
        );

        if(head_dir == Dir.RIGHT) // RIGHT
            now.x += 1;
        else if(head_dir == Dir.DOWN) // DOWN
            now.y += 1;
        else if(head_dir == Dir.LEFT) // LEFT
            now.x -= 1;
        else if(head_dir == Dir.UP) // UP
            now.y -= 1;

        return now;
    }
    void turnLeft() {
        head_dir = head_dir.turnLeft();
    }
    void turnRight() {
        head_dir = head_dir.turnRight();
    }

    void move() {
        // 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
        Pos nextPos = getNextPos();
        Obj obj = Main.board[nextPos.y][nextPos.x]; // 다음 칸에 있는 오브젝트
        
        cells.addFirst(nextPos);
        Main.board[nextPos.y][nextPos.x] = Obj.SNAKE; // 다음 칸을 뱀으로 설정
        
        // 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
        if(obj == Obj.WALL || obj == Obj.SNAKE)
            isAlive = false;
        
        // 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
        if(obj == Obj.APPLE)
            size++;
        // 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
        else {
            Pos last = cells.removeLast();
            Main.board[last.y][last.x] = Obj.EMPTY;
        }
    }
}

// 보드 위 오브젝트에 대한 자료형
// 벽, 사과, 뱀, 빈 공간
enum Obj { WALL, APPLE, SNAKE, EMPTY }

public class Main{
    static Obj[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        //벽 때문에 보드를 N+2 x N+2 사이즈로 생성
        board = new Obj[N+2][N+2];
        for (int i = 0; i < N+2; i++) {
            for (int j = 0; j < N+2; j++) {
                if (i == 0 || i == N+1 || j == 0 || j == N+1) // 바깥쪽은 벽으로 둘러싸기
                    board[i][j] = Obj.WALL;
                else // 나머지는 빈 공간
                    board[i][j] = Obj.EMPTY;
            }
        }
        
        // 사과 배치
        // K: 사과 갯수
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int apple_y = Integer.parseInt(st.nextToken());
            int apple_x = Integer.parseInt(st.nextToken());

            board[apple_y][apple_x] = Obj.APPLE;
        }
        // L: 뱀 방향 전환 횟수
        int L = Integer.parseInt(br.readLine());
        // 뱀 방향 전환 명령 저장
        
        int[] timings = new int[L];
        char[] insts  = new char[L]; // 'L', 'D'
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            timings[i] = Integer.parseInt(st.nextToken());
            insts[i] = st.nextToken().charAt(0);
        }

        int playTime;
        int ind = 0;
        Snake snake = new Snake();
        for (playTime = 1; snake.isAlive; playTime++) {
            snake.move();

            if (ind < L && playTime == timings[ind]) {
                if (insts[ind] == 'L') snake.turnLeft();
                else if (insts[ind] == 'D') snake.turnRight();
                ind++;
            }
        }
        System.out.println(--playTime);
    }
}