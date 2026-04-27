import java.io.*;
import java.util.*;

public class Main{
    static String[][] board;
    // 그 위치에 그 색이 맞는 지 확인
    static int isCorrect(String standardColor, String color, int i, int j){
        // 기준색과 같은 지 확인
        boolean isSamecolor = standardColor.equals(color);
        // 위치가 짝수인지 홀수인지 확인
        boolean iseven = (i+j)%2==0;

        // true true 이거나 false false일 때 맞은 것
        // 맞으면 0 틀리면 1
        return (isSamecolor == iseven) ? 0 : 1;
    }

    static int totalErr(String standardColor, int i_MN, int j_MN){
        int sumErr = 0;
        // 8 x 8을 조사함
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                // 대상의 실제 좌표: (i_MN+i,j_MN+i)
                // standardColor 기준으로 재정의된 좌표: (i,j)
                sumErr += isCorrect(standardColor, board[i_MN+i][j_MN+j], i, j);
            }
        }
        return sumErr;
    }

    public static void main(String[] args) throws IOException {
        /* ===== M N 입력 ===== */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        /* ===== 보드 입력 ===== */

        board = new String[M][N];
        for(int i=0; i<M; i++) {
            input = br.readLine();
            String[] colors = input.split("");
            board[i] = colors;
        }

        /* ===== 8 x 8 검사 ===== */

        int leastErr = Integer.MAX_VALUE;
        // M x N 보드에서 8 x 8을 만들 수 있는 모든 경우의 수:
        // M-8 x N-8
        for(int i=0; i<M-8+1; i++){
            for(int j=0; j<N-8+1; j++){
                // board[i][j]는 기준이 되는 컬러
                // i,j부터 8 x 8 조사 시작
                int err1 = totalErr("W",i,j);
                int err2 = totalErr("B",i,j);
                // 갱신
                if(leastErr > err1)
                    leastErr = err1;
                if(leastErr > err2)
                    leastErr = err2;
            }
        }
        System.out.println(leastErr);
    }
}