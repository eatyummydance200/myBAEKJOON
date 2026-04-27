import java.util.*;
import java.io.*;

public class Main{
    static int N;

    static int[][] heightMap;
    static int maxHeight;
    static int minHeight;

    static boolean[][] visited;
    // 물높이에 따른 안전 영역 갯수를 반환
    static int getSafeAreaNum(int waterHeight){
        // DFS 횟수로 결정

        // 갈수 있는 곳인지 아닌지
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                // 물에 잠겼다면 방문한 것으로 간주함.
                visited[i][j] = heightMap[i][j] <= waterHeight;
            }
        }
        int safeAreaCnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    safeAreaCnt++;
                    DFS(i,j);
                }
            }
        }
        return safeAreaCnt;
    }

    static void DFS(int i, int j){
        if(i<0 || j<0 || i>=N || j>=N)
            return;

        if(!visited[i][j])
            visited[i][j] = true;
        else
            return;

        DFS(i,j+1); // 오른쪽
        DFS(i+1,j); // 아래
        DFS(i,j-1); // 왼쪽
        DFS(i-1,j); // 위쪽
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // N
        N = Integer.parseInt(st.nextToken());
        // 지역별 높이 배열 입력
        heightMap = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                int input = Integer.parseInt(st.nextToken());
                heightMap[i][j] = input;

                maxHeight = Math.max(input, maxHeight);
                minHeight = Math.min(input, minHeight);
            }
        }
        // 안전한 영역의 최대 개수를 출력
        int maxSafeAreaNum = 0;
        for(int i=minHeight; i<maxHeight; i++){
            maxSafeAreaNum = Math.max(maxSafeAreaNum,getSafeAreaNum(i));
        }
        System.out.println(maxSafeAreaNum);
    }
}