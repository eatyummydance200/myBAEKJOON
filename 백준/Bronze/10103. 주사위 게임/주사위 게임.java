import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cy_score = 100;
        int sd_score = 100;

        for(int i=0; i<N; i++){
            int cy_dice = sc.nextInt();
            int sd_dice = sc.nextInt();

            if(cy_dice > sd_dice){
                sd_score -= cy_dice;
            }
            else if(cy_dice < sd_dice){
                cy_score -= sd_dice;
            }
        }
        System.out.println(cy_score);
        System.out.println(sd_score);
    }
}