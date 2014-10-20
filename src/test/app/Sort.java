package test.app;

public class Sort {
	
	private int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot) i++;
	            while (arr[j] > pivot) j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	public void quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1){quickSort(arr, left, index - 1);}
	      if (index < right){quickSort(arr, index, right);}
	}

	/*
	 * Suppose we are comparing implementations of insertion sort and merge sort on the
	 * same machine. For inputs of size n, insertion sort runs in 8n 2 steps, while merge
	 * sort runs in 64nlgn steps. For which values of n does insertion sort beat merge
	 * sort?
	 * no meaning of comparing n=1
	 * it computes all n until the smallest n which merge sort starts to beat insertion sort
	 */
	public static void compareSortingSteps(){
		double n=2;
		boolean greater=false;
		while(!greater){
			double oInsertionSort=8*n*n;
			double oMergeSort=64*n*Math.log10(n);
			if (oInsertionSort>oMergeSort){greater=true;}
			System.out.println(n);
			System.out.println("oInsertionSort: "+oInsertionSort);
			System.out.println("oMergeSort: "+oMergeSort);
			n++;
		}
	}
	/*
	 * What is the smallest value of n such that an algorithm whose running time is 100n^2
	 * runs faster than an algorithm whose running time is 2^n on the same machine?
	 */
	public static void compareSortingSteps2(){
		double n=1;
		boolean smaller=false;
		while(!smaller){
			double times1=100*n*n;
			double times2=Math.pow(2, n);
			if (times1<=times2){smaller=true;}
			n++;
		}
		System.out.println("smallest value of n: "+n);
	}

	public static void comparisonOfRunningtimes(){
		double unit=Math.pow(10, 6);
		System.out.println(" for lgn ");
		System.out.println("1 second can solve n up to: 10^"+unit);
		System.out.println("1 minute can solve n up to: 60 times of 10^"+unit);
		System.out.println("1 hour can solve n up to: 3600 times of 10^"+unit);
		System.out.println("1 day can solve n up to: 24*3600 times of 10^"+unit);
		System.out.println("1 month can solve n up to: 30*24*3600 times of 10^"+unit);
		System.out.println("1 year can solve n up to: 365*24*3600 times of 10^"+unit);
		System.out.println("1 century can solve n up to: 100*365*24*3600 times of 10^"+unit);
		System.out.println(" for square root of n ");
		double sqrtn=Math.pow(unit,2);
		System.out.println("1 second can solve n up to: "+sqrtn);
		System.out.println("1 minute can solve n up to: 60 times of "+sqrtn);
		System.out.println("1 hour can solve n up to: 3600 times of "+sqrtn);
		System.out.println("1 day can solve n up to: 24*3600 times of "+sqrtn);
		System.out.println("1 month can solve n up to: 30*24*3600 times of "+sqrtn);
		System.out.println("1 year can solve n up to: 365*24*3600 times of "+sqrtn);
		System.out.println("1 century can solve n up to: 100*365*24*3600 times of "+sqrtn);
		System.out.println(" for  n ");
		double n=unit*1;
		System.out.println("1 second can solve n up to: "+n);
		System.out.println("1 minute can solve n up to: 60 times of "+n);
		System.out.println("1 hour can solve n up to: 3600 times of "+n);
		System.out.println("1 day can solve n up to: 24*3600 times of "+n);
		System.out.println("1 month can solve n up to: 30*24*3600 times of "+n);
		System.out.println("1 year can solve n up to: 365*24*3600 times of "+n);
		System.out.println("1 century can solve n up to: 100*365*24*3600 times of "+n);
		System.out.println(" for  nlgn ");
		double nlgn=nlgn(unit);
		System.out.println("1 second can solve n up to: "+nlgn);
		System.out.println("1 minute can solve n up to: 60 times of "+nlgn);
		System.out.println("1 hour can solve n up to: 3600 times of "+nlgn);
		System.out.println("1 day can solve n up to: 24*3600 times of "+nlgn);
		System.out.println("1 month can solve n up to: 30*24*3600 times of "+nlgn);
		System.out.println("1 year can solve n up to: 365*24*3600 times of "+nlgn);
		System.out.println("1 century can solve n up to: 100*365*24*3600 times of "+nlgn);
		System.out.println(" for  n^2 ");
		double nqaure=Math.sqrt(unit*1);
		System.out.println("1 second can solve n up to: "+nqaure);
		System.out.println("1 minute can solve n up to: 60 times of "+nqaure);
		System.out.println("1 hour can solve n up to: 3600 times of "+nqaure);
		System.out.println("1 day can solve n up to: 24*3600 times of "+nqaure);
		System.out.println("1 month can solve n up to: 30*24*3600 times of "+nqaure);
		System.out.println("1 year can solve n up to: 365*24*3600 times of "+nqaure);
		System.out.println("1 century can solve n up to: 100*365*24*3600 times of "+nqaure);
		System.out.println(" for  n^3 ");
		double ncube=Math.cbrt(unit*1);
		System.out.println("1 second can solve n up to: "+ncube);
		System.out.println("1 minute can solve n up to: 60 times of "+ncube);
		System.out.println("1 hour can solve n up to: 3600 times of "+ncube);
		System.out.println("1 day can solve n up to: 24*3600 times of "+ncube);
		System.out.println("1 month can solve n up to: 30*24*3600 times of "+ncube);
		System.out.println("1 year can solve n up to: 365*24*3600 times of "+ncube);
		System.out.println("1 century can solve n up to: 100*365*24*3600 times of "+ncube);
		System.out.println(" for  2^n ");
		double twoPower=twoPower(unit,0);
		System.out.println("1 second can solve n up to: "+twoPower);
		System.out.println("1 minute can solve n up to: 60 times of "+twoPower);
		System.out.println("1 hour can solve n up to: 3600 times of "+twoPower);
		System.out.println("1 day can solve n up to: 24*3600 times of "+twoPower);
		System.out.println("1 month can solve n up to: 30*24*3600 times of "+twoPower);
		System.out.println("1 year can solve n up to: 365*24*3600 times of "+twoPower);
		System.out.println("1 century can solve n up to: 100*365*24*3600 times of "+twoPower);
		System.out.println(" for  n! ");
		double nFactorial=nFactorial(unit);
		System.out.println("1 second can solve n up to: "+nFactorial);
		System.out.println("1 minute can solve n up to: 60 times of "+nFactorial);
		System.out.println("1 hour can solve n up to: 3600 times of "+nFactorial);
		System.out.println("1 day can solve n up to: 24*3600 times of "+nFactorial);
		System.out.println("1 month can solve n up to: 30*24*3600 times of "+nFactorial);
		System.out.println("1 year can solve n up to: 365*24*3600 times of "+nFactorial);
		System.out.println("1 century can solve n up to: 100*365*24*3600 times of "+nFactorial);
		
	}
	
	private static int nlgn(double num){
		int n=1;
		double result=n*Math.log10(n);
		while(result<num){
			n++;
			result=n*Math.log10(n);
		}
		return n;
	}

	private static int twoPower(double num,int n){
		if (Math.pow(2, n)>=num){return n;}
		else{return twoPower(num,n+1);}
	}

	private static int nFactorial(double num){
		int nn=1;
		double factorial=1;
		while(factorial<num){
			nn++;
			factorial*=nn;
		}
		return nn;
	}

	public static void main(String args[]){
//		compareSortingSteps();
//		compareSortingSteps2();
//		comparisonOfRunningtimes();
		double oneMicrosecond=Math.pow(10, -6);
		double oneSecond=1;
		double unit=oneSecond/oneMicrosecond;
		double unit2=Math.pow(10, 6);
		System.out.println(unit==unit2);
	}

}
