import java.io.*;
import java.util.*;

public class Main{
    static int[] arr;
    static int[] ac_sum;

    public static int calcSum(int i, int j) {
        return ac_sum[j] - ac_sum[i-1];
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader 사용하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); // 한 줄 입력 받기
        StringTokenizer st = new StringTokenizer(input, " "); // 공백으로 구분
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // N개의 수를 입력 받음
        // 인덱스 1번부터 시작하여 저장
        input = br.readLine(); // 1. 한 줄 입력 받기
        st = new StringTokenizer(input, " "); // 2. 공백 단위로 쪼개기
        // int count = st.countTokens(); // 토큰의 개수를 센다. 문제상 N과 같음.

        arr = new int[N+1];
        ac_sum = new int[N+1];
        // ac_sum[0] = 0; 동적으로 배열을 생성했으므로 0으로 자동 초기화
        for (int i = 1; i < N+1; i++) {
            // 3. st.nextToken(); 으로 다음 토큰을 불러와 int로 casting
            arr[i] = Integer.parseInt(st.nextToken());
            ac_sum[i] = (ac_sum[i-1] + arr[i]);
        }
        
        StringBuilder output = new StringBuilder();
        
        // M개의 줄 입력 받음
        for(int index=0; index<M; index++){
            input = br.readLine();
            st = new StringTokenizer(input, " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            // arr[i]부터 arr[j]까지 누적 합 계산
            int result = calcSum(i, j);
            output.append(result);
            output.append('\n');
        }
        System.out.println(output);
    }
}