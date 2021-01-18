package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_프렌즈4블록 {
    static char map[][];
    static boolean v[][];
    static boolean flag;
    public static void main(String[] args) {
        int m,n;
        m=4;
        n=5;
        String[] board={"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int answer = 0;
        map= new char[m][n];
        //2차원 배열로 옮기기
        for(int i=0;i<board.length;i++){
            for(int j=0;j<n;j++){
                map[i][j]=board[i].charAt(j);
            }
        }


        int dr[]= {0,1,1};
        int dc[] = {1,0,1};
        while(true){
            flag=false;
            v =new boolean[m][n];
            // 1. 각 칸을 우,하,하우 를 검색해서 같으면 True로 바꿔준다.
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(map[i][j]!='.'){
                        chkDir(i,j,n,m);
                    }
                }
            }
            if(!flag)
                break;
            // 2.true된 부분들을 전부 '.'으로 바꿔준다.
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(v[i][j]){
                        map[i][j]='.';
                    }
                }
            }

            //test출력
            //  for(int i=0;i<m;i++){
            //    System.out.println(Arrays.toString(map[i]));                
            //     }
            // System.out.println("===============");

            //3. 아래부터 탐색해서 '.'인 것을 찾는다. 그리고 전부 땡긴다.
            for(int i=m-1;i>=0;i--){
                for(int j=0;j<n;j++){
                    if(map[i][j]=='.'){
                        pullDown(i,j,m);
                    }
                }
            }

        }
        //빈 공간 갯수
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]=='.')
                    answer++;
            }
        }
        System.out.println(answer);
    }

    private static void pullDown(int r, int c, int m) {
        int nr=r;
        while(nr>=0){
            if(map[nr][c]!='.'){
                map[r][c]=map[nr][c];
                map[nr][c]='.';
                break;
            }
            nr--;
        }
    }

    private static void chkDir(int r, int c, int n, int m) {
        if(r+1<m && c+1<n){
            char cur = map[r][c];
            char right=map[r][c+1];
            char bottom = map[r+1][c];
            char rBottom = map[r+1][c+1];
            if(cur==right && cur==bottom && cur==rBottom){
                flag=true;
                v[r][c]=true;
                v[r][c+1]=true;
                v[r+1][c]=true;
                v[r+1][c+1]=true;
            }
        }
    }
}
