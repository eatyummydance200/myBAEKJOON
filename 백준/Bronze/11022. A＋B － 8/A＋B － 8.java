import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=1; i<T+1; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int result = x + y;
            System.out.printf("Case #%d: %d + %d = %d \n", i, x, y, result);
        }
    }
}