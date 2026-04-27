import java.io.*;
import java.util.*;

class AbsoluteNum implements Comparable<AbsoluteNum> {
    private int abs; // 절댓값
    private int real; // 실제값

    public AbsoluteNum(int num) {
        this.abs = num > 0 ? num : num * (-1);
        this.real = num;
    }

    public int getAbs() {
        return this.abs;
    }
    public int getReal() {
        return this.real;
    }

    // 절댓값으로 비교
    // 절댓값이 같으면 실제값 비교
    @Override
    public int compareTo(AbsoluteNum other) {
        if (this.abs > other.getAbs())
            return 1;
        else if (this.abs < other.getAbs())
            return -1;
        else { // 만약 절댓값이 같으면 실제값을 비교
            if (this.real < other.getReal())
                return -1;
            else if(this.real > other.getReal())
                return 1;
            else
                return 0;
        }
    }
}
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 입력 받기
        int N = Integer.parseInt(br.readLine());
        // 절댓값에 따른 최소힙을 우선순위 큐로 구현
        PriorityQueue<AbsoluteNum> abs_min_heap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            // 0: 출력하기
            if(input == 0){
                if(abs_min_heap.isEmpty()) // 비어 있는 경우 0을 출력
                    System.out.println("0");
                else{ // 비어 있지 않으면 실제값 출력
                    int pop = abs_min_heap.poll().getReal();
                    System.out.println(pop);
                }
            }
            // 0 이외의 값은 저장
            else{
                abs_min_heap.add(new AbsoluteNum(input));
            }
        }
    }
}