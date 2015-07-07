package alogorithm;


public class StackQueueLinkedList {


	private static void queueDecode(int[] arr){
		int[] result=new int[2*arr.length-2];
		for (int i=0;i<arr.length;i++){
			result[i]=arr[i];
		}
		int head=0,tail=arr.length-1;
		while(head+1!=tail){
			tail++;
			head++;
			result[tail]=result[head];
			head++;
		}
		for (int i=0;i<result.length-2;i+=2){
			System.out.print(result[i]+" ");
		}
		System.out.print(result[result.length-2]+" ");
		System.out.print(result[result.length-1]);
	}

	private static void queueDecodeTwo(int[] arr){
		int[] result=new int[2*arr.length-2];
		for (int i=0;i<arr.length;i++){
			result[i]=arr[i];
		}
		Queue q=new Queue(0,arr.length-1,result);
		while(q.getHead()+1!=q.getTail()){
			q.setTail(q.getTail()+1);
			q.setHead(q.getHead()+1);
			int[] data=q.getData();
			data[q.getTail()]=data[q.getHead()];
			q.setHead(q.getHead()+1);
		}
		int[] data=q.getData();
		for (int i=0;i<data.length-2;i+=2){
			System.out.print(data[i]+" ");
		}
		System.out.print(data[data.length-2]+" ");
		System.out.print(data[data.length-1]);
	}


	public static void main(String[] args) {
		int[] arr={6,3,1,7,5,8,9,2,4};
		queueDecode(arr);
		System.out.println();
		queueDecodeTwo(arr);
	}

}
