import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 입력
        int N = Integer.parseInt(br.readLine());
        // 숫자들 입력
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            int input = Integer.parseInt(br.readLine());
            A[i] = input;
        }

        // 정렬
        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-i-1; j++){
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }

        // 출력
        for(int i=0; i<N; i++){
            System.out.println(A[i]);
        }
    }
}