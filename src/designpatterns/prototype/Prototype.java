package designpatterns.prototype;

public interface Prototype {

	public void printPart();
    
    Object flatClone();
    
    Object deepClone() throws Exception;
}
