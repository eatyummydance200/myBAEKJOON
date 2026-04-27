import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<3; i++)
            nums.add(Integer.parseInt(st.nextToken()));

        Collections.sort(nums);
        for(int n: nums)
            System.out.print(n + " ");
    }
}