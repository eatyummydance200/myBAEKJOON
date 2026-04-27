import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<N; i++){
            String[] testResult = sc.nextLine().split("");
            int score = 0;
            int streak = 0;
            for(int j = 0; j< testResult.length; j++){
                if(testResult[j].equals("O"))
                    streak++;
                else
                    streak = 0 ;
                score += streak;
            }
            System.out.println(score);
        }
    }
}