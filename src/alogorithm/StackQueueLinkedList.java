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

	/**
	 * tail of queue is last index, not set to next index of last one
	 * so make sure increment the tail before append an element to the queue
	 * @param arr
	 */
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
		System.out.println(data[data.length-1]);
	}

	/**
	 * stack has top index pointed to last element in the list
	 * @param str
	 */
	private static void plalindromeCheckWithStack(String str){
		int len=str.length();
		if (len%2==0){System.out.println("not plalindrome");return;}
		int mid=len/2;
		char[] stack=new char[mid];
		int top=0;
		for (int i=0;i<mid;i++){
			stack[top]=str.charAt(i);
			top++;
		}
		boolean flag=true;
		for(int i=1;i<=mid;i++){
			if (str.charAt(mid+i)!=stack[top-1]){
				flag=false;
				break;
			}
			top--;
		}
		if (flag){
			System.out.println("plalindrome");
		}else{
			System.out.println("not plalindrome");
		}
	}

	private static void game(int[] p1,int[] p2){
		Stack table=new Stack(new int[9],-1);
		int[] p1d=new int[100];
		int[] p2d=new int[100];
		int[] books=new int[9];
		for (int i=0;i<p1.length;i++){
			p1d[i]=p1[i];
			p2d[i]=p2[i];
		}
		Queue p1q=new Queue(0,p1.length-1,p1d);
		Queue p2q=new Queue(0,p2.length-1,p2d);
		int current=1;
		while(p1q.getHead()<=p1q.getTail()&&p2q.getHead()<=p2q.getTail()){
			if (current==1){
				play(p1q,table,books);
				current=2;
			}else{
				play(p2q,table,books);
				current=1;
			}
		}
		if (p2q.getHead()>p2q.getTail()){
			printMessage(p1q,1,table);
		} else if(p1q.getHead()>p1q.getTail()){
			printMessage(p2q,2,table);
		}
	}

	private static void printMessage(Queue q,int p,Stack table){
		if (p==1){
			System.out.println("player 1 win");
		}else{
			System.out.println("player 2 win");
		}
		System.out.println("player has cards");
		for (int i=q.getHead();i<=q.getTail();i++){
			System.out.print(q.getData()[i]+" ");
		}
		System.out.println();
		if (table.getTop()>=0){
			System.out.println("cards on the table");
			for (int i=0;i<=table.getTop();i++){
				System.out.print(table.getData()[i]+" ");
			}
			System.out.println();
		}else{
			System.out.println(" no card on the table");
		}
	}

	private static void play(Queue q,Stack table,int[] books){
		int card=q.getData()[q.getHead()];
		if (books[card]==0){
			q.setHead(q.getHead()+1);
			table.setTop(table.getTop()+1);
			table.getData()[table.getTop()]=card;
			books[card]=1;
		}else{
			q.setHead(q.getHead()+1);
			q.setTail(q.getTail()+1);
			q.getData()[q.getTail()]=card;
			while(table.getData()[table.getTop()]!=card){
				int t=table.getData()[table.getTop()];
				q.setTail(q.getTail()+1);
				q.getData()[q.getTail()]=t;
				books[t]=0;
				table.setTop(table.getTop()-1);
			}
		}
	}

	/**
	 * at list elements in the ascending ordered array
	 * @param arr
	 * @return Node - the head pointer of the linked list
	 */
	private static Node linkedList(int[] arr){
		Node[] linkedList=new Node[arr.length];
		linkedList[0]=new Node(arr[0]);
		for (int i=1;i<arr.length;i++){
			Node t=new Node(arr[i]);
			linkedList[i-1].setNext(t);
			linkedList[i]=t;
		}
		Node head=new Node(0);
		head.setNext(linkedList[0]);
		return head;
	}

	/**
	 * insert an element into a linked list pointed by a head pointer
	 * @param head
	 * @param number
	 */
	private static void insertNode(Node head,int number){
		Node current,prev=head;
		while((current=prev.getNext())!=null){
			if (current.getData()>=number){
				Node temp=new Node(number);
				prev.setNext(temp);
				temp.setNext(current);
				break;
			}
			prev=current;
		}
	}

	/**
	 * create a linked list from an array
	 * @param arr
	 * @return
	 */
	private static LinkedList linkedListTwo(int[] arr){
		int[] data=new int[100];
		int[] right=new int[100];
		for (int i=0;i<arr.length-1;i++){
			data[i]=arr[i];
			right[i]=i+1;
		}
		data[arr.length-1]=arr[arr.length-1];
		return new LinkedList(data,right,arr.length);
	}

	/**
	 * 
	 * @param list
	 * @param number
	 * @param index
	 */
	private static void insertAt(LinkedList list,int number,int index){
		int[] data=list.getData();
		int[] right=list.getRight();
		int tail=list.getTail();
		data[tail]=number;
		int t=right[index];
		right[index]=tail;
		right[tail]=t;
		list.setTail(tail+1);
	}
	
	/**
	 * insert at the end of the list
	 * @param list
	 * @param number
	 */
	private static void insert(LinkedList list,int number){
		int tail=list.getTail();
		insertAt(list,number,tail-1);
	}


	public static void main(String[] args) {
		int[] arr={6,3,1,7,5,8,9,2,4};
		queueDecode(arr);
		System.out.println();
		queueDecodeTwo(arr);
		plalindromeCheckWithStack("xy2azay5x");
		int[] p1={2,4,1,2,5,6};
		int[] p2={3,1,3,5,6,4};
		game(p1,p2);
		int[] list={2,4,6,8,10};
		Node head=linkedList(list);
		insertNode(head,3);
		int[] listTwo={2,3,5,8,9,10,18,26,32};
		LinkedList linklist=linkedListTwo(listTwo);
		insert(linklist,6);
		System.out.println(linklist);
	}

}
