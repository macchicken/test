package designpatterns.builder;

import java.util.ArrayList;

public class Product {

	private ArrayList<String> parts=new ArrayList<String>();
	
	public void Add(String part){
		parts.add(part);
	}
	
	public void Show(){
		if (parts!=null){
			for (String part:parts){
				System.out.println(part);
			}
		}
	}
}
