import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i=0; i<testCase; i++) {
            String schoolName = "";
            int alchoholLevel = 0;
            int schoolNum = sc.nextInt();
            sc.nextLine();
            for(int j=0; j<schoolNum; j++) {
                String[] temp = (sc.nextLine()).split(" ");
                String tempName = temp[0];
                int tempLevel = Integer.parseInt(temp[1]);

                if(alchoholLevel < tempLevel){
                    schoolName = tempName;
                    alchoholLevel = tempLevel;
                }
            }
            System.out.println(schoolName);

        }
    }
}