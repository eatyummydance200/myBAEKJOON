import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] familyTree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /* < 입력 > ======================================================================*/

        // n : 사람 수
        int n = Integer.parseInt(br.readLine());

        familyTree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) familyTree[i] = new ArrayList<>();

        // start, end : 촌수 검색 대상
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // m : 관계 수
        int m = Integer.parseInt(br.readLine());

        // 관계 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            familyTree[u].add(v);
            familyTree[v].add(u);
        }
        /* < 출력 > ======================================================================*/
        // 촌수 == 지나간 간선의 수 == BFS 횟수
        visited = new boolean[n + 1];

        int result = BFS(start, end);

        System.out.println(result);
    }

    static int BFS(int start, int end) {
        int chonsu = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            int searchRange = q.size();

            for (int i = 0; i < searchRange; i++) {
                int now = q.remove();

                if (visited[now]) continue;
                if (now == end) return chonsu;

                visited[now] = true;
                for (int next : familyTree[now]) {
                    q.add(next);
                }
            }
            chonsu++;
        }
        // 관계가 없는 경우
        return -1;
    }
}
