import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // V: 정점 개수
        // E: 간선 개수
        // start: 시작 노드
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        List<int[]>[] map = new ArrayList[V+1];


        for(int i=1; i<V+1; i++){
            map[i] = new ArrayList<>();
        }

        // 각각 u, v, w 입력
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 단방향
            map[u].add(new int[]{v,w});
        }

        int[] leastDist = new int[V+1];
        for(int i=1; i<V+1; i++)
            leastDist[i] = Integer.MAX_VALUE;
        leastDist[start] = 0;

        Queue<Integer> dist = new PriorityQueue<>((a, b) -> leastDist[a]- leastDist[b] );
        dist.add(start);

        while(!dist.isEmpty()){
            int nowNode = dist.remove();

            for(int[] nextNode: map[nowNode]){
                if(nextNode[1] == 0) continue;

                int newDist = leastDist[nowNode] + nextNode[1];
                if(newDist < leastDist[nextNode[0]]){
                    leastDist[nextNode[0]] = newDist;
                    dist.add(nextNode[0]);
                }
            }
        }
        for(int i=1; i<V+1; i++){
            int d = leastDist[i];
            if(d == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(d);
        }
    }
}