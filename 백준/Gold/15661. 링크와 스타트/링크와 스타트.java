import java.io.*;
import java.util.*;

public class Main {
    static int[][] S;
    static int N;
    
    static int[] linkTeam;
    static int[] startTeam;

    static int synergyMinGap;

    static void teamSplit(int start, int length, int splitSize){
        // 팀 분할 완료 -> 시너지 계산 후 갱신
        if(length == splitSize) {
            calcSynergy();
            return;
        }

        for(int i=start; i<=N; i++){
            linkTeam[length] = i;
            teamSplit(i+1, length+1, splitSize);
        }

    }

    static void calcSynergy(){
        // link 팀으로 먼저 선별된 선수 번호 저장
        boolean[] selected = new boolean[N+1];
        for(int l: linkTeam) selected[l] = true;

        int s=0;
        for(int j=1; j<=N; j++){
            if(!selected[j]){
                startTeam[s] = j;
                s++;
            }
        }

        int linkTeamSynergySum = 0;
        for(int p1: linkTeam){
            for(int p2: linkTeam){
                linkTeamSynergySum += S[p1][p2];
            }
        }

        int startTeamSynergySum = 0;
        for(int p1: startTeam){
            for(int p2: startTeam){
                startTeamSynergySum += S[p1][p2];
            }
        }
        int gap = Math.abs(linkTeamSynergySum - startTeamSynergySum);

        synergyMinGap = Math.min(synergyMinGap, gap);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N 입력
        N = Integer.parseInt(br.readLine());

        // S 입력
        S = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        synergyMinGap = Integer.MAX_VALUE;

        // 2개의 팀으로 나눠지는 조합 구하기
        for(int splitSize=1; splitSize<=N/2; splitSize++) {
            linkTeam = new int[splitSize]; // link 팀 선수 번호 저장
            startTeam = new int[N-splitSize]; // start 팀 선수 번호 저장
            
            teamSplit(1, 0, splitSize);
        }
        System.out.println(synergyMinGap);
    }
}
