package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기_풀이 {
	static int[][] map ;
	static int N,M, Ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("벽부수고이동하기.txt"));
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		map = new int[N+1][M+1];
		v  = new boolean[N+1][M+1][2];
		for (int r = 1; r <= N; r++) {
			String str = sc.next();
			for (int c = 1; c <= M; c++) {
				map[r][c]=str.charAt(c-1)-'0';
			}
		}
		
		//print(map);
		// Q에다 하나 저장하고 (하나 빼면서 그애와 관련된 애들 Q에가 넣는다) 반복 
		Queue <Point>Q = new LinkedList<Point>();
		Q.add(new Point(1,1,1,0));
		v[1][1][0]=true;
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			if(p.r==N&&p.c==M) {
				// 도착점에 왔어요
				Ans = Math.min(Ans, p.cnt);
				break;
			}
			for (int k = 0; k < 4; k++) {
				int nr = p.r+dr[k];
				int nc = p.c+dc[k];
				int npuk = p.puk;
				// 지도 안에 있고
				if(nr>0&&nr<=N&&nc>0&&nc<=M) {
					if(map[nr][nc]==0&&!v[nr][nc][npuk]) {
						v[nr][nc][npuk]=true;
						Q.add(new Point(nr,nc,p.cnt+1,p.puk));
					}
					
					else if(map[nr][nc]==1&&npuk==0) {
						v[nr][nc][1]=true;
						Q.add(new Point(nr,nc,p.cnt+1,1));
					}
				}
			}
		}
		System.out.println(Ans==Integer.MAX_VALUE?-1:Ans);
		
	}
	static int[] dr = {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	static boolean[][][] v;
	static class Point{
		int r,c,cnt,puk; // puk 0:안부순거 1:부순거
		Point(int r,int c,int cnt,int puk){
			this.r=r;
			this.c=c;
			this.cnt=cnt;
			this.puk=puk;
		}
	}
	private static void print(int[][] map) {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}

}
