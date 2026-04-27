import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int x = sc.nextInt();
            int y = sc.nextInt();
            // 0 0이면 종료
            if(x == 0 && y == 0)
                break;

            if(x > y)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}