import java.io.*;
import java.util.*;

class Pos {
    public int r, c;

    Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static boolean[][] houseMap;
    static int mapSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /* < 입력 > ======================================================================*/
        mapSize = Integer.parseInt(br.readLine());
        houseMap = new boolean[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < mapSize; j++) {
                houseMap[i][j] = (input[j] == '1');
            }
        }

        /* < 로직 > ======================================================================*/
        List<Integer> blocks = new ArrayList<>(); // 단지 리스트

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (houseMap[i][j]) { // 집이 있는 경우
                    int blockSize = BFS(i, j); // 한 단지(블록)의 집 수(사이즈)

                    blocks.add(blockSize);
                }
            }
        }


        /* < 출력 > ======================================================================*/
        Collections.sort(blocks);

        System.out.println(blocks.size());
        for (int block : blocks)
            System.out.println(block);
    }

    static int BFS(int searchR, int searchC) {
        // 한 단지를 조사
        int blockSize = 0;

        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(searchR, searchC));

        while (!q.isEmpty()) {
            Pos node = q.remove();
            int r = node.r;
            int c = node.c;


            if (node.r < 0 || node.r >= mapSize ||
                    node.c < 0 || node.c >= mapSize) continue; // map 밖으로 나가는 경우
            if (!houseMap[r][c]) continue; // 집이 아닌 경우는 방문하지 않음

            houseMap[r][c] = false; // 다시 방문할 수 없도록 만듦
            blockSize++;

            Pos[] next = {new Pos(r, c + 1), // 우
                    new Pos(r + 1, c), // 하
                    new Pos(r, c - 1), // 좌
                    new Pos(r - 1, c),}; // 상

            for (Pos nx : next) {
                q.add(nx);
            }
        }
        return blockSize;
    }
}
