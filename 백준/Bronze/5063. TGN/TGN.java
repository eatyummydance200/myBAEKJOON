import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            int ad_off_income = sc.nextInt();
            int ad_on_income = sc.nextInt() - sc.nextInt();

            if(ad_off_income < ad_on_income)
                System.out.println("advertise");
            else if(ad_off_income > ad_on_income)
                System.out.println("do not advertise");
            else
                System.out.println("does not matter");
        }
    }
}