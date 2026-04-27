import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // < 입력 > ==================================================

        N = Integer.parseInt(br.readLine());

        A = new int[N]; // 입력 받을 수들
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            A[i] = input;
        }
        mergeSort(A); // 이진 탐색을 위해 정렬


        int M = Integer.parseInt(br.readLine());

        int[] X = new int[M]; // 검사할 수들
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            X[i] = input;
        }

        // < 출력 > ==================================================

        for (int target : X) {
            boolean result = binarySearch(target);

            System.out.println(result ? 1 : 0);
        }
    }

    // < 이진탐색 > ==================================================
    static boolean binarySearch(int num) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (A[mid] < num) {
                left = mid + 1;
            } else if (num < A[mid]) {
                right = mid - 1;
            } else { // 찾은 경우
                return true;
            }
        }
        return false;
    }

    // < 병합 정렬 > ==================================================
    static void mergeSort(int[] arr) {
        int[] sorted = new int[arr.length];
        mergeSort(sorted, 0, arr.length - 1);
        sorted = null;
    }

    static void mergeSort(int[] sorted, int left, int right) {

        if (left == right) return;

        int mid = (left + right) / 2;

        mergeSort(sorted, left, mid);
        mergeSort(sorted, mid + 1, right);

        merge(sorted, left, mid, right);
    }

    static void merge(int[] sorted, int left, int mid, int right) {
        int l = left; // 왼쪽 배열 인덱스
        int r = mid + 1; // 오른쪽 배열 인덱스

        int idx = left;

        while (l <= mid && r <= right) {
            if (A[l] < A[r]) { // 왼쪽이 더 작으면
                sorted[idx] = A[l];
                idx++;
                l++;
            } else { // 오른쪽이 더 작으면
                sorted[idx] = A[r];
                idx++;
                r++;
            }
        }

        if (l <= mid) { // 왼쪽 리스트에 넣을 게 남았음
            while (l <= mid) {
                sorted[idx] = A[l];
                idx++;
                l++;
            }
        } else { // 오른쪽 리스트에 넣을 게 남았음
            while (r <= right) {
                sorted[idx] = A[r];
                idx++;
                r++;
            }
        }
        // 정렬된 값을 적용
        for (int i = left; i < idx; i++)
            A[i] = sorted[i];
    }
}
