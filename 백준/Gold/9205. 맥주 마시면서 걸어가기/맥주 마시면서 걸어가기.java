import java.io.*;
import java.util.*;

class Pos {
    public int x, y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static final int maxDist = 50 * 20;

    static List<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            /* < 입력 > */
            // 맥주를 파는 편의점의 개수 0 <= n <= 100
            int GS25Num = Integer.parseInt(br.readLine());

            int homeIndex = 0; // 집 좌표 인덱스
            int festivalIndex = GS25Num + 1; // 락페스티발 좌표 인덱스
            int locationNum = GS25Num + 2; // 총 건물 수

            List<Pos> locations = new ArrayList<>();

            for (int i = 0; i < GS25Num + 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                locations.add(new Pos(x, y));
            }

            /* < 로직 > */
            // map 만들기
            map = new ArrayList[locationNum];
            for (int i = 0; i < locationNum; i++) map[i] = new ArrayList<>();

            for (int i = 0; i < locationNum; i++) {
                for (int j = 0; j < locationNum; j++) {
                    if (i == j) continue;

                    Pos u = locations.get(i);
                    Pos v = locations.get(j);

                    int dist = Math.abs(u.x - v.x) + Math.abs(u.y - v.y);

                    if (dist <= maxDist) {
                        map[i].add(j);
                    }
                }
            }

            /* < 출력 > */
            boolean result = BFS(homeIndex, festivalIndex, locationNum);
            System.out.println(result ? "happy" : "sad");
        }
    }

    static boolean BFS(int start, int end, int searchRange) {
        boolean[] visited = new boolean[searchRange];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.remove();

            if (visited[node]) continue; // 이미 방문했으면 패스
            if (node == end) return true; // 락 페스티벌에 도착

            visited[node] = true;

            for (int next : map[node]) {
                q.add(next);
            }
        }
        return false;
    }
}