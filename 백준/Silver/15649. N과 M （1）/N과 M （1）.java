import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static boolean[] V;
    static int[] S;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        V = new boolean[N];
        S = new int[M];

        backtracking(0);
    }

    private static void backtracking(int length){
        if(length == M){
            printArray();
            return;
        }
        for(int i=0; i<N; i++){
            if(!V[i]){
                V[i] = true;

                S[length] = i;
                backtracking(length+1);

                V[i] = false;
            }
        }
    }

    private static void printArray(){
        for(int i=0; i<M; i++)
            System.out.print(S[i]+1 + " ");
        System.out.println();
    }
}