import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        /* ===== T 입력 ===== */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /* ===== T만큼 테스트케이스 반복 ===== */
        for(int i=0; i<T; i++){
            /* ===== p와 배열 입력 ===== */
            String p = br.readLine();;
            int n = Integer.parseInt(br.readLine());
            //addFirst addLast removeFirst removeLast 전부 시간복잡도 O(1)
            LinkedList<Integer> X = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            for(int j=0; j<n; j++){
                int x = Integer.parseInt(st.nextToken());
                X.addLast(x);
            }

            /* ===== p 사전 처리 ===== */
            // RR : 제자리이므로 무의미 -> 제거
            // D 갯수 초과 : 배열 크기를 초과하므로 -> Error 출력
            // D 갯수 동일 : 전부 삭제 -> [] 출력

            // RR 제거
            p = p.replaceAll("RR","");
            // D 갯수 초과
            int D_cnt = p.length() - p.replaceAll("D","").length();
            if(D_cnt > n){
                System.out.println("error");
                continue;
            }
            // D 갯수 동일
            else if(D_cnt == n){
                System.out.println("[]");
                continue;
            }
            // 실제로 배열을 돌리지 않고 Head만 바꿈
            boolean reverseMode = false;

            int p_length = p.length();
            for(int j=0; j<p_length; j++){
                char instruction = p.charAt(j);
                // R 명령
                if(instruction == 'R')
                    reverseMode = !reverseMode;

                // D 명령
                else if(instruction == 'D'){
                    if(!reverseMode)
                        X.pollFirst();
                    else
                        X.pollLast();
                }
            }

            // 출력
            StringBuilder sb = new StringBuilder("[");
            int X_size = X.size(); // 값이 계속 바뀌기 때문에 따로 저장
            for(int j=0; j<X_size; j++){
                if(!reverseMode)
                    sb.append(X.pollFirst());
                else
                    sb.append(X.pollLast());

                if(j < X_size-1)
                    sb.append(",");
            }
            sb.append("]");
            System.out.println(sb);
        }

    }
}