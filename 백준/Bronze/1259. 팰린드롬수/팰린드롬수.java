import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            // 숫자 맨 앞 0 제거
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0) return;

            // 숫자 -> 문자열 -> 문자 배열
            char[] nums = Integer.toString(temp).toCharArray();
            int len = nums.length;

            String result = "yes";
            for(int i=0; i<len/2; i++){
                if(nums[i] != nums[len-i-1]) {
                    result = "no";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}