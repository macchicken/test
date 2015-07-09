package alogorithm;

import java.util.Arrays;
import java.util.function.Function;

class Search {

	private static class Data{
		private int[] books;
		private int[] box;
		private int n;
		Data(int n) {
			super();
			this.books = new int[n+1];
			this.box = new int[n+1];
			this.n = n;
		}
	}

	private static class Holder{
		private int[][] next={{0,1},{1,0},{0,-1},{-1,0}};
		private int rescueP;
		private int rescueQ;
		private int n;
		private int m;
		private int min=9999;
		private int[][] books;
		private int[][] map;
		
		Holder(int p,int q,int n,int m) {
			super();
			this.rescueP = p;
			this.rescueQ = q;
			this.n=n;
			this.m=m;
			this.books=new int[n+1][m+1];
			this.map=new int[n+1][m+1];
			setObstacle();
		}
		
		private void setObstacle(){
			this.map[1][3]=1;
			this.map[3][3]=1;
			this.map[4][2]=1;
			this.map[5][4]=1;
		}
		
		void printPath(){
			for (int i=1;i<=n;i++){
				for (int j=1;j<=m;j++){
					if (books[i][j]==1){
						System.out.print(i+","+j+" ");
					}
				}
			}
		}
	}

	/**
	 * depth first search
	 * try every possibilities, such as loop the number of cases
	 * concerning how to deal with the problem at this step in the loop,
	 * and recursive call itself since the next step should be the same as previous
	 * end condition(solved the problem) at the front of dfs
	 * @param step - the number for a box
	 */
	private static void dfs(int step,Function<Data,String> result,Data holder){
		if (step==holder.n+1){// end condition:at the end of search by reaching the step bigger than maximum
			result.apply(holder);
			return;
		}
		for (int i=1;i<=holder.n;i++){
			if (holder.books[i]==0){
				holder.box[step]=i;
				holder.books[i]=1;
				dfs(step+1,result,holder);
				holder.books[i]=0;//set flag to indicate the number is ready to use for next iteration
			}
		}
	}

	public static void dfsForAllpossibilities(){
		Data pokerHolder=new Data(5);//list all combination of numbers
		Data equationHolder=new Data(9);//list all combination of numbers to make [][][]+[][][]=[][][]
		Function<Data,String> pokerResult=(t)->{
			for (int i=1;i<=t.n;i++){
				System.out.print(t.box[i]+" ");
			}
			System.out.println();
			return "";
		};
		Function<Data,String> equationResult=(t)->{
			if ((t.box[1] * 100 + t.box[2] * 10 + t.box[3] + t.box[4] * 100
					+ t.box[5] * 10 + t.box[6]) == (t.box[7] * 100 + t.box[8]
					* 10 + t.box[9])) {
				System.out.println(Arrays.toString(t.box));
			}
			return "";
		};
		dfs(1,pokerResult,pokerHolder);// start at the beginning
	}

	private static void rescue(int x,int y,int step,Holder holder){
		if (x==holder.rescueP&&y==holder.rescueQ){
			if (step<=holder.min){
				holder.min=step;
				holder.printPath();
				System.out.println();
			}
			return;
		}
		for (int i=0;i<=3;i++){
			int tx=x+holder.next[i][0];
			int ty=y+holder.next[i][1];
			if (tx <= holder.n && tx >= 1 && ty >= 1 && ty <= holder.m
					&& holder.books[tx][ty] == 0 && holder.map[tx][ty] == 0) {
				holder.books[tx][ty] = 1;
				rescue(tx, ty, step + 1, holder);
				holder.books[tx][ty] = 0;
			}
		}
	}

	public static void rescueWithDFS(){
		Holder holder=new Holder(4,3,5,4);
		holder.books[1][1]=1;
		rescue(1,1,0,holder);
		System.out.println(holder.min);
	}
	

	public static void main(String[] args) {
//		dfsForAllpossibilities();
		rescueWithDFS();
	}

}
