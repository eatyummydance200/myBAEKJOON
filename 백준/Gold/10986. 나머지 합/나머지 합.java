import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N, M 입력
        int N = Integer.parseInt(st.nextToken()); // A 개수
        int M = Integer.parseInt(st.nextToken()); // 나눌 수

        int[] A = new int[N + 1];
        
        // A 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());

            // 구간 합
            // 나머지 연산 분배 법칙
            A[i] = A[i - 1] + input % M;
            A[i] %= M;
        }
        A[0] = 0; // 상협의 도움 : 0을 추가하면 0의 개수를 세는 것과 같은 효과

        int[] numCnt = new int[M + 1]; // 1~M까지 숫자가 몇 번 나왔는지

        for (int num : A)
            numCnt[num]++;

        long result = 0L; // M으로 나누어 떨어지는 구간 합의 개수 저장

        for (int i = 0; i <= M; i++) {
            long c = numCnt[i];
            result += c * (c - 1) / 2;
        }
        System.out.println(result);
    }
}
