import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();
        int oven_time = sc.nextInt();

        min += oven_time;
        if(min >= 60) {
            hour += min/60;
            min %= 60;
            if(hour >= 24)
                hour %= 24;
        }

        System.out.printf("%d %d \n", hour, min);
    }
}