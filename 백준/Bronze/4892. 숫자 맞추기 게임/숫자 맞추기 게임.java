import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            input = Integer.parseInt(br.readLine());

            if (input == 0) break;
            index++;

            // index 표현
            sb.append(index).append(". ");

            // 짝수인 경우
            if (input % 2 == 0) {
                sb.append("even ");
                sb.append(input / 2);
            }
            // 홀수인 경우
            else {
                sb.append("odd ");
                sb.append((input - 1) / 2);
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}