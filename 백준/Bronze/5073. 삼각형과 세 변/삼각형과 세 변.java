import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            String input = br.readLine();

            if(input.equals("0 0 0")) break; // 종료 조건
            st = new StringTokenizer(input, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a+b > c && b+c > a && c+a > b) { // vaild
                if(a == b && b == c)
                    System.out.println("Equilateral");
                else if(a==b || b==c || c==a)
                    System.out.println("Isosceles");
                else
                    System.out.println("Scalene");
            }
            else 
                System.out.println("Invalid");
        }
    }
}