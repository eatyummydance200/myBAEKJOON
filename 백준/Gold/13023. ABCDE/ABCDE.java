import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] G;
    static boolean isABCDE;

    static void DFS(int start, int relationDepth) {
        if (isABCDE) return;

        if (relationDepth == 5) {
            isABCDE = true;
            return;
        }

        if (!visited[start]) {
            visited[start] = true;

            for (int next : G[start])
                DFS(next, relationDepth + 1);

            visited[start] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N, M 입력
        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        G = new ArrayList[N]; // 0 ~ N-1 번호를 가진 사람들
        for (int i = 0; i < N; i++)
            G[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            G[u].add(v);
            G[v].add(u);
        }
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (isABCDE) break;

            DFS(i, 0);
        }

        String result = isABCDE ? "1" : "0";
        System.out.println(result);
    }
}
