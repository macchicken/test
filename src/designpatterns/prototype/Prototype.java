package designpatterns.prototype;

public interface Prototype extends Cloneable{

	public void printPart();
	public void setPart();
	public void createNewPart();
    
    Object shallowClone() throws CloneNotSupportedException;

    Object flatClone();
    
    Object deepClone() throws Exception;
}
