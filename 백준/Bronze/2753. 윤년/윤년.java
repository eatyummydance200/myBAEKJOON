import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        if(N%400 == 0)
            result = 1;
        else if(N%100 == 0)
            result = 0;
        else if(N%4 ==0)
            result = 1;

        System.out.println(result);
    }
}