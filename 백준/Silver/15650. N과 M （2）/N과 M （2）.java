import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] output;
    static StringBuilder sb;

    static void NandM(int index, int least) {
        if (index == M) {
            for (int out : output)
                sb.append(out).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = least; i <= N; i++) {
            output[index] = i;
            NandM(index + 1, i + 1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 1 ~ N 숫자
        M = Integer.parseInt(st.nextToken()); // 몇 자리 숫자

        output = new int[M];
        sb = new StringBuilder();

        NandM(0, 1);
        System.out.println(sb);
    }
}