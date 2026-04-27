import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cCnt = 0; // 열 가로 카운트
        int rCnt = 0; // 행 세로 카운트

        // 가로
        for(int i=0; i<W; i+=(M+1)){
            cCnt++;
        }

        // 세로
        for(int i=0; i<H; i+=(N+1)){
            rCnt++;
        }

        System.out.println(rCnt * cCnt);
    }
}