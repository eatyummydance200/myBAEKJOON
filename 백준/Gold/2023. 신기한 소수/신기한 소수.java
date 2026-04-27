import java.util.*;
import java.io.*;

public class Main{
    static int N;

    static boolean isPrime(int num){
        for(int i=2; i<=num/2; i++){ // num/2보다 큰 약수는 존재하지 않음
            if(num%i == 0) // 나누어 떨어지는 순간 소수가 아님
                return false;
        }
        return true; // 모두 통과하면 소수로 판단
    }

    static void findMagicPrime(int num){
        // 소수인지 확인
        if(!isPrime(num))
            return;
        // 입력한 자리수와 일치하면 출력하고 재귀 종료
        if(Integer.toString(num).length() == N ){
            System.out.println(num);
            return;
        }

        // 왼쪽으로 시프트
        num *= 10;
        // 다음 자릿수로는 1,3,7,9만 올 수 있음
        findMagicPrime(num+1);
        findMagicPrime(num+3);
        findMagicPrime(num+7);
        findMagicPrime(num+9);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N: 자릿수
        N = Integer.parseInt(br.readLine());

        // N번째 자릿수: 소수 2,3,5,7로 시작
        // 나머지는 이미 소수가 아니므로 탐색 x
        findMagicPrime(2);
        findMagicPrime(3);
        findMagicPrime(5);
        findMagicPrime(7);
    }
}