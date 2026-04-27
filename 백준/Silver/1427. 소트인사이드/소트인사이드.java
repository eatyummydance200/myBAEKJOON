import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine().chars()                 
                .map(c -> c-'0')  
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print);      
    }
}