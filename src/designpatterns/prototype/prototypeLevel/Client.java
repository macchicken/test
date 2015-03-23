package designpatterns.prototype.prototypeLevel;

public class Client {

	public static void main(String[] args) {
		PrototypeManager pma=new PrototypeManager();
		Prototype original=new ConcretePrototype();
		Prototype pro=(Prototype) (original).clone();
		pma.add(pro);
		System.out.println("total objects in manager: "+pma.getSize());
		System.out.println("first object equal to original: "+pma.get(0).equals(original));
	}

}
