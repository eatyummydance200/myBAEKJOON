import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt(); // 대상이 되는 숫자

            if (num == -1) // -1이 나오면 테스트 종료
                break;

            int divisorSum = 0;
            ArrayList<Integer> divisors = new ArrayList<>(); // 약수를 담을 리스트
            for (int i = 1; i < num / 2 + 1; i++) { // 약수는 num의 절반을 넘지 않음
                if (num % i == 0) {
                    divisors.add(i);
                    divisorSum += i;
                }
            }
            if (divisorSum == num) {
                System.out.printf("%d = ", num);
                for (int divisor : divisors) {
                    System.out.print(divisor);
                    if (divisor != num / 2)
                        System.out.print(" + ");
                    else
                        System.out.println("");
                }
            } else
                System.out.printf("%d is NOT perfect.\n", num);
        }
    }
}