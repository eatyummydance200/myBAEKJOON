import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = 0;
        
        sc.nextLine();
        for(String i: sc.nextLine().split("")){
            int n = Integer.parseInt(i);
            result += n;
        }
        System.out.println(result);
    }
}