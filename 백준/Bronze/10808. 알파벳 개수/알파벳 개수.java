import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] alphabet = new int[26];
        for (int i = 0; i < 26; i++) alphabet[i] = 0;

        char[] input = br.readLine().toCharArray();

        for (char c : input) {
            int alIndex = c - 'a';
            alphabet[alIndex]++;
        }

        for (int cnt : alphabet) {
            sb.append(cnt).append(' ');
        }
        System.out.print(sb);
    }
}