package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Programmers_쿼드압축후개수세기 {
    static int zero,one;
    public static void main(String[] args) {
        int[] answer = {};
        int [][] arr={{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int N=arr[0].length;
        zero=0;
        one=0;
        Quad(0,0,N,arr);
        answer = new int[2];
        answer[0]=zero;
        answer[1]=one;
        System.out.println(Arrays.toString(answer));
    }
    public static void Quad(int row,int col,int N,int[][] arr){
        int number=arr[row][col];
        boolean chk=false;
        for(int i=row;i<row+N;i++){
            for(int j=col;j<col+N;j++){
                if(arr[i][j]!=number){
                    chk=true;
                    break;
                }

            }
            if(chk)
                break;
        }

        if(chk){
            Quad(row,col,N/2,arr);
            Quad(row,col+N/2,N/2,arr);
            Quad(row+N/2,col,N/2,arr);
            Quad(row+N/2,col+N/2,N/2,arr);
        }else{
            if(number==0)
                zero++;
            else
                one++;
        }
    }
}
