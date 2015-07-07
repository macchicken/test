package alogorithm;

import java.util.Arrays;
import java.util.Random;

public class Sorts {

	/**
	 * sort a list of integer Descending
	 * pre-condition: must know the maximum number to initialise a temporay array
	 * complexcity: O(max+1+2*arr.length)
	 * @param arr
	 */
	private static void simpleBarrelSort(int[] arr,int max){
		int[] temp=new int[max+1];
		for (int i:arr){
			temp[i]++;
		}
		for (int i=temp.length-1,j=0;i>=0;i--){
			if (temp[i]!=0){
				int loop=temp[i];
				while(loop>0){
					arr[j]=i;
					j++;
					loop--;
				}
			}
		}
	}

	/**
	 * sort a list of number Descending
	 * continue to compare adjancent numbers and move the smaller to next location
	 * complexity: O((arr.length+1)*arr.length/2)
	 * @param arr
	 */
	private static void bubbleSort(int[] arr){
		for (int i=0;i<arr.length;i++){
			int t=arr.length-i;
			for (int j=1;j<t;j++){
				if (arr[j-1]<arr[j]){
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}

	/**
	 * compare the left number with pivot and compare the right number with pivot
	 * til first seen that left number biggher than piovt
	 * and right number smaller than pivot
	 * swap them, keep repeating the procedure til left == right
	 * then swap the number with pivot
	 * then do the above for left part of array and right part of array
	 * @param left
	 * @param right
	 * @param arr
	 */
	private static void quickSort(int left,int right,int[] arr){
		if (left>right){return;}
		int pivot=arr[left];int i=left,j=right;
		while(true){
			while(arr[j]>=pivot&&i<j){
				j--;
			}
			while(arr[i]<=pivot&&i<j){
				i++;
			}
			if (i == j) {
				arr[left] = arr[i];
				arr[i] = pivot;
				break;
			}
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		quickSort(left,i-1,arr);
		quickSort(i+1,right,arr);
	}

	/**
	 * 啊哈!算法 第一章 - 小哼买书
	 * 桶排序
	 * @param people
	 * @param arr
	 */
	private static void methodOne(int people,int[] arr){
		long start=System.currentTimeMillis();
		int[] table=new int[1001];int count=0;
		if (people!=arr.length){return;}
		for (int i:arr){
			if (table[i]==0){
				count++;
				table[i]=1;
			}
		}
		int[] result=new int[count]; 
		for (int i=0,j=0;i<table.length;i++){
			if (table[i]==1){
				result[j]=i;
				j++;
				if (j==count){break;}
			}
		}
		System.out.println(count);
		System.out.println(Arrays.toString(result));
		System.out.println((System.currentTimeMillis()-start)+"ms");
	}

	/**
	 * 啊哈!算法 第一章 - 小哼买书
	 * 快速排序
	 * @param people
	 * @param arr
	 */
	private static void methodTwo(int people,int[] arr){
		long start=System.currentTimeMillis();
		if (people!=arr.length){return;}
		quickSort(0,arr.length-1,arr);
		System.out.print("[");
		int count=0;
		for (int i=0;i<arr.length;i++){
			if (i+1<arr.length){
				if (arr[i]!=arr[i+1]){
					System.out.print(arr[i]+", ");
					count++;
				}
			}
		}
		System.out.println(arr[arr.length-1]+"]");
		count++;
		System.out.println(count);
		System.out.println((System.currentTimeMillis()-start)+"ms");
	}


	public static void main(String args[]){
		int[] arr=new int[100];
		int max=100;
		Random seed=new Random();
		for (int i=0;i<100;i++){
			arr[i]=seed.nextInt(max);
		}
		simpleBarrelSort(arr,max);
		System.out.println(Arrays.toString(arr));
		int[] bubbleArr={5,2,6,3,9,5,1,8};
		bubbleSort(bubbleArr);
		System.out.println(Arrays.toString(bubbleArr));
		int[] quickSortArr={6,1,2,7,5,9,3,4,5,10,8};
		quickSort(0,quickSortArr.length-1,quickSortArr);
		System.out.println(Arrays.toString(quickSortArr));
		int[] books={20,40,32,67,40,20,89,300,400,15};
		methodOne(10,books);
		methodTwo(10,books);
	}

}
