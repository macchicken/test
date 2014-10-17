package codingbat;

import java.util.Arrays;

public class Logic2 {

	private boolean makeBricks(int small, int big, int goal) {
		if ((goal/1)<=small){return true;}
		else{
			int bigpieces=goal/5;
			int bigleft=goal%5;
			if (bigleft==0&&bigpieces<=big){return true;}
			if (bigpieces>big){
				return (goal-big*5)<=small*1;
			}
			return (goal-bigpieces*5)<=small*1;
		}
	}
	
	private int loneSum(int a, int b, int c) {
		  int result=0;
		  if (a!=b){
			  if (a!=c&&b!=c){result=a+b+c;}
			  else if (b==c){result=a;}
			  else if (b!=c&&a==c){result=b;}
		  }else{
			  if (b!=c){result=c;}
		  }
		  return result;
	}

	private int luckySum(int a, int b, int c) {
		  if (a==13){return 0;}
		  else{
			  if (b==13){return a;}
			  else{
				  return c==13?a+b:a+b+c;
			  }
		  }
	}

	private int fixTeen(int n){
		if (13<=n&&n<=19){
			return n==15||n==16?n:0;
		}
		return n;
	}

	private int noTeenSum(int a, int b, int c) {
		return fixTeen(a)+fixTeen(b)+fixTeen(c);
	}

	private int round10(int num){
		if (num<=10){
			if (num>=5){return 10;}
			else{return 0;}
		}
		return (num/10)*10+round10(num%10);
	}

	private int roundSum(int a, int b, int c) {
		  return round10(a)+round10(b)+round10(c);
	}

	private boolean closeFar(int a, int b, int c) {
		  int diffab=Math.abs(a-b);
		  int diffbc=Math.abs(b-c);
		  int diffac=Math.abs(a-c);
		  if (diffab<=1){
			  return diffbc>1&&diffac>1;
		  }else if(diffbc<=1){
			  return diffab>1&&diffac>1;
		  }else if (diffac<=1){
			  return diffbc>1&&diffab>1;
		  }
		  return false;
	}

	private int blackjack(int a, int b) {
		  int diffa=21-a;
		  int diffb=21-b;
		  if (diffa>=0){
			  if (diffb>=0){return diffa<=diffb?a:b;}
			  return a;
		  }else if (diffb>=0){return b;}
		  return 0;
	}

	private boolean evenlySpaced(int a, int b, int c) {
		  int[] arr=new int[3];
		  arr[2]=Math.max(Math.max(a, b),c);
		  arr[0]=Math.min(Math.min(a, b),c);
		  if (arr[0]==a){
			  arr[1]=Math.min(b, c);
		  }else if (arr[0]==b){
			  arr[1]=Math.min(a, c);
		  }else{
			  arr[1]=Math.min(a, b);
		  }
		  return arr[2]-arr[1]==arr[1]-arr[0];
	}

	private int makeChocolate(int small, int big, int goal) {
		  int bigc=goal/5;
		  int bigLeft=goal%5;
		  if (bigc<=big){
			  if (bigLeft==0){return 0;}
			  int smallLeft=bigLeft/1;
			  return smallLeft<=small?smallLeft:-1;
		  }else{
			  int smallLeft=(goal-5*big)/1;
			  return smallLeft<=small?smallLeft:-1;
		  }
	}

	public void testmakeBricks(){
		System.out.println(true==makeBricks(1000000, 1000, 1000100));
		System.out.println(true==makeBricks(3, 1, 8));
		System.out.println(false==makeBricks(3, 1, 9));
		System.out.println(true==makeBricks(3, 2, 10));
		System.out.println(true==makeBricks(20, 0, 19));
		System.out.println(false==makeBricks(20, 0, 21));
		System.out.println(false==makeBricks(20, 4, 51));
		System.out.println(true==makeBricks(20, 4, 39));
	}
	
	public void testloneSum(){
		System.out.println(loneSum(1, 2, 3)==6);
		System.out.println(loneSum(3, 2, 3)==2);
		System.out.println(loneSum(3, 3, 3)==0);
	}
	
	public void testluckySum(){
		System.out.println(luckySum(1, 2, 3)==6);
		System.out.println(luckySum(1, 2, 13)==3);
		System.out.println(luckySum(1, 13, 3)==1);
	}
	
	public void testnoTeenSum(){
		System.out.println(noTeenSum(1, 2, 3)==6);
		System.out.println(noTeenSum(2, 13, 1)==3);
		System.out.println(noTeenSum(2, 1, 14)==3);
	}
	
	public void testroundSum(){
		System.out.println(roundSum(16, 17, 18)==60);
		System.out.println(roundSum(12, 13, 14)==30);
		System.out.println(roundSum(6, 4, 4)==10);
	}
	
	public void testcloseFar(){
		System.out.println(closeFar(1, 2, 10)==true);
		System.out.println(closeFar(1, 2, 3)==false);
		System.out.println(closeFar(4, 1, 3)==true);
		System.out.println(closeFar(10, 10, 8) ==true);
	}
	
	public void testblackjack(){
		System.out.println(blackjack(19,21)==21);
		System.out.println(blackjack(21,19)==21);
		System.out.println(blackjack(19,22)==19);
	}

	public void testmakeChocolate(){
		System.out.println(makeChocolate(4, 1, 9)==4);
		System.out.println(makeChocolate(4, 1, 10)==-1);
		System.out.println(makeChocolate(4, 1, 7)==2);
		System.out.println(makeChocolate(4, 1, 5)==0);
		System.out.println(makeChocolate(1, 2, 5)==0);
		System.out.println(makeChocolate(6, 1, 10)==5);
		System.out.println(makeChocolate(6, 1, 11)==6);
		System.out.println(makeChocolate(6, 2, 10)==0);
		System.out.println(makeChocolate(60, 100, 550)==50);
		System.out.println(makeChocolate(1000, 1000000, 5000006)==6);
		System.out.println(makeChocolate(7, 1, 12)==7);
	}
	
	public void testevenlySpaced(){
		System.out.println(evenlySpaced(2, 4, 6)==true);
		System.out.println(evenlySpaced(4, 6, 2)==true);
		System.out.println(evenlySpaced(4, 6, 3)==false);
	}
}
