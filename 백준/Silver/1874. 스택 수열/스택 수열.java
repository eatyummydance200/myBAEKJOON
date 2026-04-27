import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n 입력 받기
        int n = Integer.parseInt(br.readLine());

        // 수열 입력 받기
        int[] sequence = new int[n];
        for(int i=0; i<n; i++){
            sequence[i] = Integer.parseInt(br.readLine());
        }
        // 스택
        Deque<Integer> stack = new ArrayDeque<>();

        StringBuilder result = new StringBuilder();
        int i = 1; //
        for(int term: sequence){
            // term이 나올 때까지 push
            for(; i<=term; i++)
            {
                stack.push(i);
                result.append("+\n");
            }
            // top의 값이 수열과 일치하면 pop
            if(stack != null & stack.getFirst() == term){
                stack.pop();
                result.append("-\n");
            }
            // 예외인 경우는 NO
            else {
                result = new StringBuilder("NO");
                break;
            }
        }
        System.out.println(result);
    }
}