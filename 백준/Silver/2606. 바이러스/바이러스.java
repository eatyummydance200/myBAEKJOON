import java.util.*;
import java.io.*;

public class Main{
    static List<Integer>[] network;
    static boolean[] visited;
    static int affectedPcCnt;

    static void BFS(int pc){
        Queue<Integer> q = new ArrayDeque<>();
        visited[pc] = true;
        for(int connectedPc: network[pc])
            q.add(connectedPc);

        while(!q.isEmpty()){
            int nowPc = q.peek();
            q.remove();

            if(!visited[nowPc]){
                visited[nowPc] = true;
                affectedPcCnt++;
                for(int connectedPc: network[nowPc])
                    q.add(connectedPc);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터의 수와 네트워크 연결 수 입력
        int pcNum = Integer.parseInt(br.readLine());
        int networkSize = Integer.parseInt(br.readLine());

        // 네트워크 초기화
        network = new ArrayList[pcNum+1];
        for(int i=1; i<pcNum+1; i++)
            network[i] = new ArrayList<>();

        // 컴퓨터 간 네트워크 연결 입력
        for(int i=0; i<networkSize; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            network[u].add(v);
            network[v].add(u);
        }

        affectedPcCnt = 0;
        visited = new boolean[pcNum+1];
        BFS(1);

        System.out.println(affectedPcCnt);
    }
}