import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 입력 받기
        int N = Integer.parseInt(br.readLine());
        // 카드
        Deque<Integer> card = new ArrayDeque<>();
        // 1~N까지 차례대로 삽입
        for(int i=1; i<=N; i++){
            card.addLast(i);
        }
        // 마지막 카드가 남을 때까지 반복
        while(card.size() != 1){
            card.removeFirst(); // 맨 위 제거
            if(card.size() == 1)
                break;
            card.addLast(card.pollFirst()); // 맨 위 카드 맨 뒤로 이동
        }
        System.out.println(card.getFirst());
    }
}