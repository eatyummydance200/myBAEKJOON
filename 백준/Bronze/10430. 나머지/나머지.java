import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];

        for(int i=0; i<nums.length; i++)
            nums[i] = sc.nextInt();

        System.out.println((nums[0]+nums[1])%nums[2]);
        System.out.println(
                ((nums[0]%nums[2])+(nums[1]%nums[2]))%nums[2]
        );
        System.out.println((nums[0]*nums[1])%nums[2]);
        System.out.println(
                ((nums[0]%nums[2])*(nums[1]%nums[2]))%nums[2]
        );
    }
}