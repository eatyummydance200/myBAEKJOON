import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken()); // 고정비용
        int B = Integer.parseInt(st.nextToken()); // 가변비용
        int C = Integer.parseInt(st.nextToken()); // 노트북 가격

        //공식 A / (C-B)
        // 0이거나 음수이면 손익분기점이 존재하지 않음
        if((C-B) <= 0){
            System.out.println(-1);
            return;
        }

        int result = A / (C-B) + 1; // 최초로 이익이 발생하는 시점 + 1
        System.out.println(result);

    }
}