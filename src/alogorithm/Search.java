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

	/**
	 * print out the cases of combination of numbers
	 * depth first search
	 * try every possibilities, such as loop the number of cases
	 * concerning how to deal with the problem at this step in the loop,
	 * and recursive call itself since the next step should be the same as previous
	 * end condition at the front of the dfs
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


	public static void main(String[] args) {
		Data pokerHolder=new Data(5);
		Data stickHolder=new Data(9);
		Function<Data,String> pokerResult=(t)->{
			for (int i=1;i<=t.n;i++){
				System.out.print(t.box[i]+" ");
			}
			System.out.println();
			return "";
		};
		Function<Data,String> stickResult=(t)->{
			if ((t.box[1] * 100 + t.box[2] * 10 + t.box[3] + t.box[4] * 100
					+ t.box[5] * 10 + t.box[6]) == (t.box[7] * 100 + t.box[8]
					* 10 + t.box[9])) {
				System.out.println(Arrays.toString(t.box));
			}
			return "";
		};
		dfs(1,pokerResult,pokerHolder);// start at the beginning
	}

}
