import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); // 한 줄 입력 받기
        StringTokenizer st = new StringTokenizer(input, " "); // 공백으로 구분
        int N = Integer.parseInt(st.nextToken()); // N종류의 동전
        int K = Integer.parseInt(st.nextToken()); // 가치
        
        int[] coins = new int[N]; 
        for(int i=N-1; i>=0; i--){
            input = br.readLine();
            coins[i] = Integer.parseInt(input);
        }

        /** 
         * 필요한 동전의 개수를 구하는 것.
         * 잔돈에서 가치가 큰 동전부터 거슬러 준다.
         */
        
        int cnt = 0;
        /* while 대신 for, foreach를 쓰는 이유
         * 이펙티브 자바; 아이템 57, 58
         */
        // 잔돈을 모두 거슬러 줄 때까지
        for(int coin: coins) {
            // 가치가 큰 동전부터 하나씩 거슬러 준다.
            // 더 이상 남은 돈을 동전으로 거슬러 줄 수 없으면
            // 다음 동전으로 넘어간다.
            cnt += K/coin;
            K %= coin;
        }
        System.out.println(cnt);
    }
}