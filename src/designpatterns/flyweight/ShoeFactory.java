package designpatterns.flyweight;

import java.util.ArrayList;


public class ShoeFactory {

	private static class SingletonHolder {
		private static final ShoeFactory INSTANCE = new ShoeFactory();
		private static ArrayList<Shoe> shoes=new ArrayList<Shoe>();
	}
	private ShoeFactory() {}
	public static ShoeFactory getInstance() {
		return SingletonHolder.INSTANCE;
	}

	Shoe getShoe(String color, int size, String position){
		for (Shoe shoe:SingletonHolder.shoes){
			if (shoe.getColor() == color && shoe.getSize() == size) {
				shoe.setPosition(position);
				return shoe;
			}
		}
		Shoe shoe = new Shoe();
		shoe.setColor(color);
		shoe.setSize(size);
		shoe.setPosition(position);
		SingletonHolder.shoes.add(shoe);
		return shoe;
	}
}
