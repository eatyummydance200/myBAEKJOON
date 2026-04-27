import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int Top = Integer.parseInt(st.nextToken());
        int Curr = Integer.parseInt(st.nextToken());
        int StartLink = Integer.parseInt(st.nextToken());
        int Up = Integer.parseInt(st.nextToken());
        int Down = Integer.parseInt(st.nextToken());

        int buttonCnt = 0;
        boolean[] visited = new boolean[Top+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(Curr);

        while(!q.isEmpty()){
            int i_width = q.size();

            for(int i=0; i<i_width; i++){
                int now = q.remove();

                if (now == StartLink) {
                    System.out.println(buttonCnt);
                    return;
                }

                if (now < 1 || now > Top) continue;
                if (visited[now]) continue;
                visited[now] = true;

                q.add(now + Up);
                q.add(now - Down);
            }
            buttonCnt++;
        }
        System.out.println("use the stairs");
    }
}