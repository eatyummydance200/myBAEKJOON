import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    static boolean[] visited; // 방문 기록
    static ArrayList<Integer> G[]; // 그래프
    public static void DFS(int Node){
        visited[Node] = true;
        for(int nextNode: G[Node]){
            if(!visited[nextNode])
                DFS(nextNode);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // N: 노드의 수
        // M: 엣지의 수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int connected_component = 0; // 연결 요소의 수
        visited = new boolean[N+1];
        // 불 자료형은 멤버 변수이므로 자동으로 false로 초기화
        // 메서드 지역 변수는 초기화 x

        // 그래프 초기화: 인덱스 1부터 사용
        G = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            G[i] = new ArrayList<>();
        }

        // 노드 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방향
            G[u].add(v);
            G[v].add(u);
        }

        // DFS
        for(int i=1; i<N+1; i++){
            if(!visited[i]){
                connected_component++;
                DFS(i);
            }
        }
        System.out.println(connected_component);
    }
}