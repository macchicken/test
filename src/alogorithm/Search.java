package alogorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	
	private static class Node{
		private int x;
		private int y;
		private int step;
		private int parent;
	}

	private static class BoomMan{
		private int sum;
		private int locX;
		private int locY;
		public BoomMan(int sum, int locX, int locY) {
			super();
			this.sum = sum;
			this.locX = locX;
			this.locY = locY;
		}
	}

	private static class NodeQueue{
		private int head;
		private int tail;
		private Node[] que;
		public NodeQueue(int head, int tail, Node[] que) {
			super();
			this.head = head;
			this.tail = tail;
			this.que = que;
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

	/**
	 * 第四章- 解救小哈
	 * @param x - current location in the row
	 * @param y - current location in the column
	 * @param step - steps has been taken
	 * @param holder - holder for data used in the program
	 */
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

	/**
	 * 第四章- 解救小哈
	 */
	public static void rescueWithDFS(){
		Holder holder=new Holder(4,3,5,4);
		holder.books[1][1]=1;
		rescue(1,1,0,holder);
		System.out.println(holder.min);
	}
	

	/**
	 * 第四章- 解救小哈
	 * solve by breath first search
	 * try every possible moves at each step, 
	 * save them in the moves storage if they are ok to move(there are some contraints)
	 * move the step to next one after finishing trying
	 * among each possible moves, check if it solves the problems,
	 * if so jump out the iteration
	 * @param n
	 * @param m
	 * @param rescueP
	 * @param rescueQ
	 */
	public static void rescueWithBFS(int n,int m,int rescueP,int rescueQ){
		Node[] que=new Node[2501];// step storage implemented by queue
		for (int i=1;i<2501;i++){
			que[i]=new Node();
		}
		int head,tail;
		int[][] map=new int[51][51];
		int[][] books=new int[51][51];// stores passed location
		int[][] next={{0,1},{1,0},{0,-1},{-1,0}};
		map[1][3]=1;//set obstacle
		map[3][3]=1;
		map[4][2]=1;
		map[5][4]=1;//set obstacle
		head=tail=1;
		que[tail].x=1;// start at 1
		que[tail].y=1;// start at 1
		que[tail].step=0;
		que[tail].parent=0;
		tail++;
		books[1][1]=1;
		boolean success = false;
		while(head<tail){
			for (int i=0;i<=3;i++){
				int tx=que[head].x+next[i][0];
				int ty=que[head].y+next[i][1];
				if (tx<=n&&tx>=1&&ty<=m&&ty>=1&&books[tx][ty]==0&&map[tx][ty]==0){
					books[tx][ty]=1;
					que[tail].x=tx;
					que[tail].y=ty;
					que[tail].step=que[head].step+1;
					que[tail].parent=head;
					tail++;
					if (tx==rescueP&&ty==rescueQ){
						int current=tail-1;
						System.out.println(que[current].step);
						while(current>=1){
							System.out.print(que[current].x+", "+que[current].y+" -> ");
							current=que[current].parent;
						}
						success=true;
						break;
					}
				}
			}
			if (success){System.out.println();break;}
			head++;
		}
	}
	
	private static int calculate(char[][] map,int x,int y,int[] direction){
		int sum=0;int i=x,j=y;
		while(map[i][j]!='#'){
			if (map[i][j]=='G'){
				sum++;
			}
			i=i+direction[0];
			j=j+direction[1];
		}
		return sum;
	}

	private static char[][] readMap(int n,int m,String mapFile){
		String dir=System.getProperty("user.dir");
		char[][] map=new char[n+1][m+1];BufferedReader reader=null;
		try {
			reader=new BufferedReader(new FileReader(dir+mapFile));
			String line;int i=1;
			while((line=reader.readLine())!=null){
				char[] t=line.toCharArray();
				for (int j=1;j<=m;j++){
					map[i][j]=t[j-1];
				}
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	/**
	 * 第四章- 炸弹人计算一颗炸弹可以炸多少人
	 * @param startX
	 * @param startY
	 * @param n
	 * @param m
	 */
	public static void boomManWithBFS(int startX,int startY,int n,int m){
		Node[] que=new Node[401];
		for (int i=1;i<401;i++){
			que[i]=new Node();
		}
		int head,tail;
		char[][] map=readMap(n,m,"\\src\\alogorithm\\map.txt");
		int[][] books=new int[n+1][m+1];
		int[][] next={{0,1},{1,0},{0,-1},{-1,0}};
		head=tail=1;
		que[tail].x=startX;
		que[tail].y=startY;
		tail++;
		books[startX][startY]=1;
		int sum=0,locX=0,locY=0;
		for (int i=0;i<4;i++){
			sum+=calculate(map,que[head].x,que[head].y,next[i]);
		}
		while(head<tail){
			for (int i=0;i<4;i++){
				int tx=que[head].x+next[i][0];
				int ty=que[head].y+next[i][1];
				if (tx<n&&tx>1&&ty<m&&ty>1&&books[tx][ty]==0&&map[tx][ty]=='.'){
					books[tx][ty]=1;
					que[tail].x=tx;
					que[tail].y=ty;
					tail++;
					int t=0;
					for (int j=0;j<4;j++){
						t+=calculate(map,tx,ty,next[j]);
					}
					if (t>sum){sum=t;locX=tx;locY=ty;}
				}
			}
			head++;
		}
		System.out.println("max "+sum+" locX "+locX+" locY "+locY);
	}

	private static void boomManDFSInner(int n, int m, int x,int y,int[][] books,
			char[][] map,int[][] next, BoomMan bm) {
		int sum=0;
		for (int i=0;i<4;i++){
			sum+=calculate(map,x,y,next[i]);
		}
		if (sum>bm.sum){bm.sum=sum;bm.locX=x;bm.locY=y;}
		for (int i=0;i<4;i++){
			int tx=x+next[i][0];
			int ty=y+next[i][1];
			if (tx<n&&tx>1&&ty<m&&ty>1&&books[tx][ty]==0&&map[tx][ty]=='.'){
				books[tx][ty]=1;
				boomManDFSInner(n,m,tx,ty,books,map,next,bm);
			}
		}
	}

	/**
	 * 第四章- 炸弹人计算一颗炸弹可以炸多少人
	 * @param startX
	 * @param startY
	 * @param n
	 * @param m
	 */
	public static void boomManWithDFS(int startX,int startY,int n,int m){
		char[][] map=readMap(n,m,"\\src\\alogorithm\\map.txt");
		int[][] books=new int[n+1][m+1];
		int[][] next={{0,1},{1,0},{0,-1},{-1,0}};
		BoomMan man=new BoomMan(0,startX,startY); 
		boomManDFSInner(n,m,startX,startY,books,map,next,man);
		System.out.println("max "+man.sum+" locX "+man.locX+" locY "+man.locY);
	}

	/**
	 * 第四章- 宝岛探险 计算登陆岛屿的面积
	 * @param landX
	 * @param landY
	 * @param n
	 * @param m
	 */
	public static void adventureWithBFS(int landX, int landY,int n,int m){
		char[][] map=readMap(n,m,"\\src\\alogorithm\\island.txt");
		if (map[landX][landY]=='0'){System.out.println("area "+0);return;}
		int max=n*m+1;int head=1,tail=1;
		Node[] que=new Node[max];
		for (int i=1;i<max;i++){
			que[i]=new Node();
		}
		int[][] next={{0,1},{1,0},{0,-1},{-1,0}};
		int[][] books=new int[n+1][m+1];
		int area=0;
		books[landX][landY]=1;
		que[tail].x=landX;
		que[tail].y=landY;
		tail++;
		area=1;
		while(head<tail){
			for (int i=0;i<4;i++){
				int tx=que[head].x+next[i][0];
				int ty=que[head].y+next[i][1];
				if (tx>=1&&tx<=n&&ty>=1&&ty<=m&&books[tx][ty]==0&&map[tx][ty]!='0'){
					books[tx][ty]=1;
					que[tail].x=tx;
					que[tail].y=ty;
					tail++;
					area++;
				}
			}
			head++;
		}
		System.out.println("area "+area);
	}
	
	private static int adventureWithDFSinner(int x, int y, int n, int m,
			int[][] books, int[][] next, char[][] map) {
		if (map[x][y]=='0'){
			return 0;
		}
		int area=1;books[x][y]=1;
		for (int i=0;i<4;i++){
			int tx=x+next[i][0];
			int ty=y+next[i][1];
			if (tx>=1&&tx<=n&&ty>=1&&ty<=m&&books[tx][ty]==0&&map[tx][ty]!='0'){
				books[tx][ty]=1;
				area+=adventureWithDFSinner(tx,ty,n,m,books,next,map);
			}
		}
		return area;
	}

	/**
	 * 第四章- 宝岛探险 计算登陆岛屿的面积
	 * @param landX
	 * @param landY
	 * @param n
	 * @param m
	 */
	public static void adventureWithDFS(int landX, int landY,int n,int m){
		char[][] map=readMap(n,m,"\\src\\alogorithm\\island.txt");
		if (map[landX][landY]=='0'){System.out.println("area "+0);return;}
		int[][] books=new int[n+1][m+1];
		int[][] next={{0,1},{1,0},{0,-1},{-1,0}};
		int area=adventureWithDFSinner(landX,landY,n,m,books,next,map);
		System.out.println("area "+area);
	}
	
	private static void setMapArea(int x, int y, NodeQueue queue, int n, int m,
			char[][] map, int[][] books, int[][] next,char colour) {
		while(queue.head<queue.tail){
			for (int i=0;i<4;i++){
				int tx=queue.que[queue.head].x+next[i][0];
				int ty=queue.que[queue.head].y+next[i][1];
				if (tx>=1&&tx<=n&&ty>=1&&ty<=m&&books[tx][ty]==0&&map[tx][ty]!='0'){
					books[tx][ty]=1;
					queue.que[queue.tail].x=tx;
					queue.que[queue.tail].y=ty;
					map[tx][ty]=colour;
					queue.tail++;
				}
			}
			queue.head++;
		}
	}

	/**
	 * 第四章- 宝岛探险 获得所有独立小岛的范围并标识
	 * @param n
	 * @param m
	 */
	public static void adventureWholeMapWithBFS(int n,int m){
		char[][] map=readMap(n,m,"\\src\\alogorithm\\island.txt");
		int[][] books=new int[n+1][m+1];
		int[][] next={{0,1},{1,0},{0,-1},{-1,0}};
		int max=n*m+1;
		Node[] que=new Node[max];
		for (int i=1;i<max;i++){
			que[i]=new Node();
		}
		NodeQueue queue=new NodeQueue(1,1,que);
		char colour='a';int c=0;
		for (int i=1;i<=n;i++){
			for (int j=1;j<=m;j++){
				if (books[i][j]==0&&map[i][j]!='0') {
					books[i][j]=1;
					queue.que[queue.tail].x=i;
					queue.que[queue.tail].y=j;
					colour+=c;
					map[i][j]=colour;
					queue.tail++;
					setMapArea(i, j, queue, n, m, map, books, next,colour);
					c++;
				}
			}
		}
		for (int i=1;i<=n;i++){
			for (int j=1;j<=m;j++){
				System.out.print(map[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}

	private static void adventureWholeMapWithDFSinner(int x, int y,
			int n, int m, char[][] map, int[][] books, int[][] next, char colour) {
		if (map[x][y]=='0'){
			return;
		}
		map[x][y]=colour;
		books[x][y]=1;
		for (int i=0;i<4;i++){
			int tx=x+next[i][0];
			int ty=y+next[i][1];
			if (tx>=1&&tx<=n&&ty>=1&&ty<=m&&books[tx][ty]==0&&map[tx][ty]!='0'){
				map[tx][ty]=colour;
				books[tx][ty]=1;
				adventureWholeMapWithDFSinner(tx,ty,n,m,map,books,next,colour);
			}
		}
	}

	/**
	 * 第四章- 宝岛探险 获得所有独立小岛的范围并标识
	 * @param n
	 * @param m
	 */
	public static void adventureWholeMapWithDFS(int n, int m){
		char[][] map=readMap(n,m,"\\src\\alogorithm\\island.txt");
		int[][] books=new int[n+1][m+1];
		int[][] next={{0,1},{1,0},{0,-1},{-1,0}};
		char colour='a';int c=0;
		for (int i=1;i<=n;i++){
			for (int j=1;j<=m;j++){
				if (books[i][j]==0&&map[i][j]!='0'){
					colour+=c;
					adventureWholeMapWithDFSinner(i,j,n,m,map,books,next,colour);
					c++;
				}
			}
		}
		for (int i=1;i<=n;i++){
			for (int j=1;j<=m;j++){
				System.out.print(map[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
//		dfsForAllpossibilities();
//		System.out.println();
//		rescueWithDFS();
//		System.out.println();
//		rescueWithBFS(5,4,4,3);
//		System.out.println();
//		boomManWithBFS(4,4,13,13);
//		System.out.println();
//		boomManWithDFS(4,4,13,13);
//		System.out.println();
//		adventureWithBFS(6,8,10,10);
//		System.out.println();
//		adventureWithDFS(6,8,10,10);
//		System.out.println();
		adventureWholeMapWithBFS(10,10);
		System.out.println();
		adventureWholeMapWithDFS(10,10);
	}

}
