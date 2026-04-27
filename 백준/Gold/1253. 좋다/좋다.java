import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] A;

    static boolean isGood(int numIndex) {
        long num = A[numIndex];

        // 양쪽 끝점으로 세팅
        int left = 0;
        int right = N - 1;

        while (left < right) { // 서로 다른 두 수의 합
            long sum = A[left] + A[right];

            if (sum == num) {
                if (left != numIndex && right != numIndex)
                    return true;
            }

            if (sum < num || left == numIndex) { // 합이 작다면 left을 왼쪽으로 움직여서 합을 증가시킴
                left++;
            } else { // 합이 크다면 right를 오른쪽으로 움직여서 합을 감소시킴
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        N = Integer.parseInt(br.readLine());

        // A 입력
        A = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            long input = Integer.parseInt(st.nextToken());
            A[i] = input;
        }
        Arrays.sort(A); // 오름차순으로 정렬

        int goodNumCnt = 0;

        for (int i = 0; i < N; i++) {
            if (isGood(i)) goodNumCnt++;
        }
        System.out.println(goodNumCnt);
    }
}
