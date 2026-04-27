import java.util.*;
import java.io.*;

enum Obj{
    WALL, ROAD
}

class Pos{
    public int i;
    public int j;
    Pos(int i, int j){
        this.i = i;
        this.j = j;
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N과 M 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 미로 초기화
        Obj[][] maze = new Obj[N+2][M+2];
        boolean[][] visited = new boolean[N+2][M+2];

        for(int i=0; i<N+2; i++)
            for(int j=0; j<M+2; j++)
                maze[i][j] = Obj.WALL;
        // 미로 입력 받기
        for(int i=1; i<=N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                if (input.charAt(j - 1) == '1')
                    maze[i][j] = Obj.ROAD;
            }
        }

        //BFS
        int moveCnt = 1;

        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(1,1));

        while(!q.isEmpty()){
            int size = q.size();
            for(int l=0; l<size; l++) {
                Pos now = q.remove();

                int i = now.i;
                int j = now.j;

                if(i == N && j == M){
                    System.out.println(moveCnt);
                    return;
                }

                if (maze[i][j] == Obj.WALL) continue;
                if (visited[i][j]) continue;
                visited[i][j] = true;

                q.add(new Pos(i, j + 1)); // RIGHT
                q.add(new Pos(i + 1, j)); // DOWN
                q.add(new Pos(i, j - 1)); // LEFT
                q.add(new Pos(i - 1, j)); // UP
            }
            moveCnt++; // BFS 횟수 == 움직인 횟수
        }
    }
}