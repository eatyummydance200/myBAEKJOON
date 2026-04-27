import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=1; i<T+1; i++){
            int result = sc.nextInt() + sc.nextInt();
            System.out.printf("Case #%d: %d \n", i, result);
        }
    }
}