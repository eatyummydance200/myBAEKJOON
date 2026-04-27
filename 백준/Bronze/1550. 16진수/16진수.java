import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        char[] input = br.readLine().toCharArray();

        // i는 자릿 수를 의미
        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            int hexDigit = (int) Math.pow(16, input.length - i - 1);

            if ('0' <= c && c <= '9') {// 숫자인 경우
                result += (c - '0') * hexDigit;
            } else if ('A' <= c && c <= 'F') {
                result += (c - 'A' + 10) * hexDigit;
            }
        }

        System.out.println(result);
    }
}
