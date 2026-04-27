import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arrSize = Integer.parseInt(st.nextToken());
        int quizNum = Integer.parseInt(st.nextToken());

        int[][] S = new int[arrSize+1][arrSize+1];

        for(int i=0; i<arrSize+1; i++){ // 누적합을 구하기 위해 인덱스 0은 0으로 채움
            S[i][0] = 0;
            S[0][i] = 0;
        }
        // 입력 받고 누적합 배열 만들기
        for(int i=1; i<arrSize+1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<arrSize+1; j++) {
                int A = Integer.parseInt(st.nextToken());
                S[i][j] = A + S[i][j-1] + S[i-1][j] - S[i-1][j-1];
                // A B
                // C D
                // => D + B + C - A
                // 이전 누적 합 더하고 겹치는 A는 빼줌
            }
        }
        // 구간 합 구하기
        for(int i=0; i<quizNum; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken()); // 행
            int y1 = Integer.parseInt(st.nextToken()); // 열
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1];
            System.out.println(result);
        }
    }
}