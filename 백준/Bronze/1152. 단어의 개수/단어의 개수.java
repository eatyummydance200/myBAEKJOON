import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int wordNum = 0;
            while(st.hasMoreTokens()){
                st.nextToken();
                wordNum++;
            }
            System.out.println(wordNum);
    }
}