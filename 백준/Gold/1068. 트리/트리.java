import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] parentOfNode;
    static int removeNode;
    static boolean[] isLeaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // <입력>
        N = Integer.parseInt(br.readLine());

        parentOfNode = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            parentOfNode[i] = input;
        }

        removeNode = Integer.parseInt(br.readLine());

        // <로직>
        // 초기화
        isLeaf = new boolean[N];
        for (int i = 0; i < N; i++)
            isLeaf[i] = true;

        // 자신의 조상을 거슬러 올라가면서 삭제 노드인지 확인한다.
        List<Integer> buffer = new ArrayList<>(); // 삭제할 노드를 저장
        
        for (int i = 0; i < N; i++) {
            int parent = i;

            while (parent != -1) {
                if (parent == removeNode) { // 만약 부모가 삭제 대상이라면
                    isLeaf[i] = false; // 삭제되면서 리프노드 제외
                    buffer.add(i);
                    break;
                }

                parent = parentOfNode[parent]; // 부모의 부모노드로 이동 -> 조상 거슬러 올라가기
            }
        }
        for(int node:buffer) parentOfNode[node] = -1;

        // 리프 노드인지 확인한다.
        for (int i = 0; i < N; i++) { // 반복문을 돌면서 자식이 있다면 false로 바꿔줌
            int parent = parentOfNode[i]; // 부모 노드

            if (parent >= 0) {
                isLeaf[parent] = false;
            }
        }

        // <출력>
        int leafNodeCnt = 0;

        for (boolean il : isLeaf) {
            if (il) leafNodeCnt++;
        }

        System.out.println(leafNodeCnt);
    }
}