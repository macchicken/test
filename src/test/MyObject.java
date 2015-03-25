package test;

public class MyObject extends OObject implements Comparable<MyObject>{


	public MyObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyObject(int val) {
		super(val);
		// TODO Auto-generated constructor stub
	}

	String getName() {return "MyObject";}
	
	public static void main(String[] args) {
		System.out.println("comparisons: "
				+ ((new MyObject(100)).compareTo(new MyObject(200)) < 0 ) + ",  "
				+ ((new MyObject(100)).compareTo(new MyObject(200)) <= 0) + ",  "
				+ ((new MyObject(100)).compareTo(new MyObject(200)) > 0) + ",  "
				+ ((new MyObject(100)).compareTo(new MyObject(200)) >= 0) + ",  "
				+ ((new MyObject(100)).compareTo(new MyObject(200)) == 0));
        return;
    }

	@Override
	public int compareTo(MyObject o) {
		if (this!=null&&o!=null){
			return (new Integer(this.getValue())).compareTo(new Integer(o.getValue()));
		}
		return 0;
	}


}
