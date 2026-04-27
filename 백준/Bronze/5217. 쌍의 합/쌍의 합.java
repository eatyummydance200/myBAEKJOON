import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        int input;
        for (int i = 0; i < testCase; i++) {
            input = Integer.parseInt(br.readLine());

            sb.append("Pairs for ").append(input).append(": ");

            int low = 1;
            int high = input - 1;
            while (low < high) {
                if (low != 1)
                    sb.append(", ");

                sb.append(low).append(" ").append(high);

                low++;
                high--;
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}