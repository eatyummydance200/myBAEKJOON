import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 입력
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        int left = 1;
        int right = 1;
        int sum = 1;

        while (left <= right) {
            if (N == sum) {
                cnt++;
            }

            if (N <= sum) {
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }
        System.out.println(cnt);
    }
}
