import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i=0; i<3; i++)
            nums.add(sc.nextInt());
        nums.sort(Comparator.naturalOrder());
        System.out.println(nums.get(1));
    }
}