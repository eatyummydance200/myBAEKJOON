import java.util.*;
import java.io.*;

class binaryTree {
    private static StringBuilder result = new StringBuilder();
    private binaryTree leftNode;
    private binaryTree rightNode;
    private int value;

    binaryTree() {
        value = -1;
    }

    void insert(int input) {
        if (value == -1) {
            this.value = input;
            return;
        }

        if (input < value) {
            if (leftNode == null) this.leftNode = new binaryTree();
            this.leftNode.insert(input);
        } else {
            if (rightNode == null) this.rightNode = new binaryTree();
            this.rightNode.insert(input);
        }
    }

    // 후위 순회
    void postOrder() {
        if (value == -1) return;

        if (leftNode != null) leftNode.postOrder();
        if (rightNode != null) rightNode.postOrder();

        result.append(this.value).append('\n');
    }

    void resultPrint() {
        System.out.print(result);
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // <입력>
        List<Integer> input = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            int node = Integer.parseInt(line);

            input.add(node);
        }

        // <로직>
        // 1. 전위 순회 입력을 이진 트리에 저장한다.
        binaryTree headNode = new binaryTree();
        for (int node : input) {
            headNode.insert(node);
        }

        // 2. 후위 순회하기
        headNode.postOrder();

        // <출력>
        headNode.resultPrint();
    }
}