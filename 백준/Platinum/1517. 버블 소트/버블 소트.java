import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static long swapCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /* < 입력 > */
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
        }

        /* < 로직 > */
        swapCnt = 0;
        mergeSort();

        /* < 출력 > */
        System.out.println(swapCnt);
    }

    static void mergeSort() {
        int[] sorted = new int[arr.length];

        mergeSort(sorted, 0, arr.length - 1);
    }

    static void mergeSort(int[] sorted, int left, int right) {

        if (left >= right) return;

        int mid = (left + right) / 2; // 가운데를 기준으로 split

        mergeSort(sorted, left, mid);
        mergeSort(sorted, mid + 1, right);

        merge(sorted, left, mid, right);
    }

    static void merge(int[] sorted, int left, int mid, int right) {
        int index = left;
        int l = left;
        int r = mid + 1;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) { // 왼쪽이 작을 때
                sorted[index] = arr[l];
                l++;
                index++;
            } else { // 오른쪽이 작을 때
                sorted[index] = arr[r];
                r++;
                index++;

                swapCnt += Math.abs(index - r); // 오른쪽에서 가져올 때 스왑이 발생함.
            }
        }

        // 왼쪽이 남았을 때
        while (l <= mid) {
            sorted[index] = arr[l];
            index++;
            l++;
        }

        // 오른쪽이 남았을 때
        while (r <= right) {
            sorted[index] = arr[r];
            index++;
            r++;
        }

        // 복사하기
        for (int i = left; i < index; i++) {
            arr[i] = sorted[i];
        }
    }
}
