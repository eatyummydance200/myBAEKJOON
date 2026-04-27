import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        long S2 = 2*S;
        // n(n+1) / 2 = s 를 활용
        int N = (int)((-1 + Math.sqrt(1 + 8*S)) / 2);
        System.out.println(N);
    }
}