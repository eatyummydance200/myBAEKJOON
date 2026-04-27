import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int cityNum = Integer.parseInt(st.nextToken());
        int bridgeNum = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        List<Integer>[] map = new ArrayList[cityNum+1];
        for(int i=1; i<cityNum+1; i++)
            map[i] = new ArrayList<>();

        int[] leastDist = new int[cityNum+1];
        for(int i=1; i<cityNum+1; i++)
            leastDist[i] = Integer.MAX_VALUE;
        leastDist[start] = 0;

        // 입력
        for(int i=0; i<bridgeNum; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 단방향
            map[u].add(v);
        }

        PriorityQueue<Integer> dist = new PriorityQueue<>();
        dist.add(start);

        while(!dist.isEmpty()){
            int city = dist.peek();
            dist.remove();

            for(int c: map[city]){
                // 더 최단 경로이면 갱신해줌
                if(leastDist[city]+1 < leastDist[c]){
                    leastDist[c] = leastDist[city]+1;
                    dist.add(c);
                }
            }
        }
        // 최단 거리가 K인 도시를 출력하기 위해 저장
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<cityNum+1; i++)
            if(leastDist[i] == K)
                result.add(i);

        if(result.isEmpty()){
            System.out.println(-1);
            return;
        }

        Collections.sort(result);

        for(int res: result)
            System.out.println(res);
    }
}