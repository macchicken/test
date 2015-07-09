package alogorithm;

public class Enumeration {

	private static int[] numbers={6,2,5,5,4,5,6,3,7,6};

	private static int fun(int x){
		int num=0;
		while(x/10!=0){
			num+=numbers[x%10];
			x/=10;
		}
		num+=numbers[x];
		return num;
	}
	
	/**
	 * pre-codition m<=24
	 * @param m
	 */
	private static void enumerated(int m){
		int total=0;
		for (int a=0;a<=1111;a++){
			for (int b=0;b<=1111;b++){
				int c=a+b;
				if ((fun(a)+fun(b)+fun(c))==(m-4)){
					System.out.println(a+"+"+b+"="+c);
					total++;
				}
			}
		}
		System.out.println("total number of quations "+total);
	}

	
	public static void main(String args[]){
		long start=System.currentTimeMillis();
		enumerated(24);
		System.out.println("time taken "+(System.currentTimeMillis()-start));
	}

}
