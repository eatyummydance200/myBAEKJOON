import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String grade = sc.nextLine();
        double grade_score = 0.0;

        switch (grade.charAt(0)) {
            case 'A':
                grade_score = 4.0;
                break;
            case 'B':
                grade_score = 3.0;
                break;
            case 'C':
                grade_score = 2.0;
                break;
            case 'D':
                grade_score = 1.0;
                break;
            default:
                grade_score = 0.0;
        };

        if(grade_score != 0.0) {
            switch (grade.charAt(1)) {
                case '+':
                    grade_score += 0.3;
                    break;
                case '0':
                    grade_score += 0.0;
                    break;
                case '-':
                    grade_score += -0.3;
                    break;
                default:
                    break;
            };
        }
        System.out.println(grade_score);
    }
}