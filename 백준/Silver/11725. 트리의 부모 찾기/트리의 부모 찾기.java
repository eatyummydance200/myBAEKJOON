import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] tree;
    static int[] parentOfNode;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        parentOfNode = new int[N + 1];
        visited = new boolean[N + 1];

        DFS(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++)
            sb.append(parentOfNode[i]).append('\n');

        System.out.print(sb);
    }

    static void DFS(int node) {
        visited[node] = true; // 방문하기

        for (int child : tree[node]) { // 내려가기
            if (visited[child]) continue;

            parentOfNode[child] = node; // 부모 기록하기
            DFS(child);
        }
    }
}