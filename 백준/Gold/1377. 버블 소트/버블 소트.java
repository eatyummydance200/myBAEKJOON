import java.io.*;
import java.util.*;

class Num implements Comparable<Num> {
    public int value;
    public int index;

    Num(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Num num) {
        if (num.value < this.value)
            return 1;
        else if (num.value > this.value)
            return -1;
        else
            return 0;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // A 입력
        List<Num> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            A.add(new Num(input, i));
        }

        Collections.sort(A);

        int movedCnt = 0;

        for (int i = 0; i < N; i++) {
            // 왼쪽으로 한 칸씩 밖에 이동할 수 없음.
            // 즉 왼쪽으로 가장 많이 이동한 거리 == 버블 정렬 횟수
            int gap = A.get(i).index - i; // 양수가 왼쪽으로 이동한 경우

            movedCnt = Math.max(movedCnt, gap);
        }
        movedCnt++; // 마지막에 확인할 때 1회 추가됨

        System.out.println(movedCnt);
    }
}
