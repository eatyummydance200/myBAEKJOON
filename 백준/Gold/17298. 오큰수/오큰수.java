import java.util.*;
import java.io.*;

class NGE {
    public int NGEIndex;
    public int num;

    NGE(int num, int NGEIndex) {
        this.num = num;
        this.NGEIndex = NGEIndex;
    }
}

public class Main {
    static int N;
    static NGE[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 수열의 크기

        A = new NGE[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            A[i] = new NGE(input, -1);
        }

        // 가장 오른쪽부터(오른쪽 두번째) 시작 구간합처럼 자신의 오른쪽 NGE 와 num 비교

        for (int i = N - 2; i >= 0; i--) {
            if (A[i].num < A[i + 1].num) { // 자신으로부터 가장 오른쪽에 있는 num 부터 비교
                A[i].NGEIndex = i + 1;
            } else {
                int nextNGEIndex = A[i + 1].NGEIndex;
                while (nextNGEIndex >= 0) {
                    if (A[i].num < A[nextNGEIndex].num) {
                        A[i].NGEIndex = nextNGEIndex;
                        break;
                    }

                    nextNGEIndex = A[nextNGEIndex].NGEIndex;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (NGE output : A) {
            if (output.NGEIndex == -1)
                sb.append(-1).append(" ");
            else
                sb.append(A[output.NGEIndex].num).append(" ");
        }

        System.out.println(sb);
    }
}