import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N+1; i++)
            sb.append("Hello World, Judge " + i + "!\n");
        System.out.print(sb);
    }
}