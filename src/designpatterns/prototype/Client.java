package designpatterns.prototype;

public class Client {

	public static void main(String[] args) throws Exception {
		ConcretePrototype originate, cloned, deepCloned;
        originate = new ConcretePrototype();

        Thread.sleep(2000);

        cloned = (ConcretePrototype)originate.flatClone();
        deepCloned = (ConcretePrototype)originate.deepClone();
        System.out.println(originate);
        System.out.println(cloned);
        System.out.println(deepCloned);
        originate.printPart();
        cloned.printPart();
        deepCloned.printPart();
	}

}
