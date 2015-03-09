package designpatterns.flyweight;

public class Shoe {

	private String color;
	private int size;
	private String position;

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "colour: "+color+" size: "+size+" position: "+position;
	}
	
	
}
