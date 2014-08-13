package codingbat;

public class Logic1 {
	
	private static Logic1 my=new Logic1();
	
	public static Logic1 getInstance(){
		return my;
	}

	private int dateFashion(int you,int date){
		if (you<=2||date<=2){
			return 0;
		}else if (you>=8||date>=8){
			return 2;
		}else{
			return 1;
		}
	}
	
	//test method
	public void testdateFashion(){
		System.out.println(2==dateFashion(5, 10));
		System.out.println(0==dateFashion(5, 2));
		System.out.println(1==dateFashion(5, 5));
	}

}
