import java.util.*;

public class Main{
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    static int N,M;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 정점의 개수
        M = sc.nextInt(); // 간선의 개수
        int V = sc.nextInt(); // 시작하는 정점 번호

        // 저장할 행렬 +) 인덱스 0은 사용하지 않음
        A = new ArrayList[N+1];
        for(int i=1; i<N+1; i++)
            A[i] = new ArrayList<Integer>();

        // 간선의 수만큼 반복
        for(int i=0; i<M; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();

            // 양방향
            A[S].add(E);
            A[E].add(S);
        }
        //작은 것부터 먼저 방문을 위해 정렬
        for(int i=1; i<N+1; i++)
            Collections.sort(A[i]);

        /* DFS */
        visited = new boolean[N+1];
        DFS(V);

        System.out.println("");
        /* BFS */
        visited = new boolean[N+1];
        BFS(V);

    }
    public static void DFS(int Node){
        System.out.print(Node+" ");
        visited[Node] = true;

        for(int i: A[Node])
            if(!visited[i])
                DFS(i);
    }
    public static void BFS(int Node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node] = true;

        while(!queue.isEmpty()){
            int now_Node = queue.poll();
            System.out.print(now_Node+" ");
            for(int i: A[now_Node]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}