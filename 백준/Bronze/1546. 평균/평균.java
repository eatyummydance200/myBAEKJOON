import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        // N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 성적 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        double avg = 0;
        double M = 0; // M: 최고 성적
        for(int i=0; i<N; i++){
            double score = Double.parseDouble(st.nextToken());

            if(M < score) // 최고 성적 갱신
                M = score;

            avg += score;
        }
        avg = avg / M * 100 / N; // 새로운 평균을 구하는 공식 적용
        System.out.println(avg);
    }
}