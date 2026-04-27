import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] output;
    static StringBuilder sb;

    static void NandM(int step) {
        if (step == M) {
            for (int out : output)
                sb.append(out).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            output[step] = i;
            NandM(step + 1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 1 ~ N 숫자
        M = Integer.parseInt(st.nextToken()); // 몇 자리 숫자

        output = new int[M];
        sb = new StringBuilder();

        NandM(0);
        System.out.println(sb);
    }
}