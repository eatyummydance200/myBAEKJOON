import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 수빈과 동생의 위치 입력
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 시간 == BFS 횟수
        int time = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        boolean[] visited = new boolean[100000+1];

        // 수빈과 동생의 위치가 같아지면 탈출
        while(true){
            // time 번째 BFS 수행
            int BFSWidth = q.size();
            for(int i=0; i<BFSWidth; i++) {
                int pos = q.remove();

                if (pos > 100000 || pos < 0) continue;
                if (visited[pos]) continue;
                visited[pos] = true;

                if (pos == end) {
                    System.out.println(time);
                    return;
                }

                q.add(pos * 2); // 순간이동 : 2X
                q.add(pos + 1); // 앞으로 걷기 : X+1
                q.add(pos - 1); // 뒤로 걷기 : X-1
            }
            time++;
        }
    }
}