import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int b3 = Integer.parseInt(br.readLine());
        int b2 = Integer.parseInt(br.readLine());
        
        int b1 = b2 + (b2-b3);
        System.out.println(b1);
    }
}