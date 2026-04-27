import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] output;
    static int[] input;
    static StringBuilder sb;
    static boolean[] visited;

    static void NandM(int index) {
        if (index == M) {
            for (int out : output)
                sb.append(out).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            output[index] = input[i];

            visited[i] = true;
            NandM(index + 1);
            visited[i] = false;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 1 ~ N 숫자
        M = Integer.parseInt(st.nextToken()); // 몇 자리 숫자

        input = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        output = new int[M];
        visited = new boolean[N];
        sb = new StringBuilder();

        NandM(0);
        System.out.println(sb);
    }
}