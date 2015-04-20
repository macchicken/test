package designpatterns.prototype;

import java.io.Serializable;

public class Part implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5713424461847600611L;

	private char[][] str;

	public Part() {
		super();
		this.str = new char[3][3];
	}
	
	public void changePart(){
		this.str[0][0]='a';
	}
	
	public char printCotent(){
		return this.str[0][0];
	}
}
