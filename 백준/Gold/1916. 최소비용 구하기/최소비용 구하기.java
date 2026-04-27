import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());

        // 지도 초기화
        int[][] map = new int[cityNum+1][cityNum+1]; // 메모리 제한 안 걸림
        for(int i=1; i<cityNum+1; i++){
            for(int j=1; j<cityNum+1; j++){
                if(i == j)
                    map[i][j] = 0;
                else
                    map[i][j] = Integer.MAX_VALUE;
            }
        }
        // 버스 입력
        for(int i=0; i<busNum; i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            // 중복 입력되었을 때 이전보다 더 짧은 버스인 경우 갱신
            if(map[from][to] > cost)
                map[from][to] = cost;
        }
        // 출발점과 도착점 입력
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 출발점에서 모든 점까지의 거리
        int[] dist = new int[cityNum+1];
        for(int i=1; i<cityNum+1; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;

        // 출발점에서 먼저 시작
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        queue.add(start);

        while(!queue.isEmpty()){
            int nowCity = queue.remove();

            for(int nextCity=1; nextCity<cityNum+1; nextCity++){
                if(nextCity == nowCity) continue;
                if(map[nowCity][nextCity] == Integer.MAX_VALUE) continue;

                int nowToNext = dist[nowCity] + map[nowCity][nextCity]; // nowCity를 거치고 next로 갈 때 비용
                if(dist[nextCity] > nowToNext) { // 기존 비용보다 nowCity를 경유한 비용이 더 최소라면 갱신
                    dist[nextCity] = nowToNext;
                    queue.add(nextCity);
                }
            }
        }

        // 출력: 출발지 -> 도착지 최소 비용
        System.out.println(dist[end]);
    }
}