package test;

public class OObject {
	public OObject() {
		super();
	}
	int value;
    OObject(int val) {this.value = val;}
    int getValue() {return this.value;}
    void setValue(int val) {this.value = val;}
    String getName() {return "Object";}
}
