package designpatterns.prototype;

public class Client {

	public static void main(String[] args) throws Exception {
		Prototype originate, cloned, shallowCloned, deepCloned;
        originate = new ConcretePrototype();

        Thread.sleep(2000);

        cloned = (Prototype) originate.flatClone();
        deepCloned = (Prototype) originate.deepClone();
        shallowCloned=(Prototype) originate.shallowClone();
        System.out.println("originate "+originate);
        System.out.println("flatCloned "+cloned);
        System.out.println("deepCloned "+deepCloned);
        System.out.println("shallowCloned "+shallowCloned);
        originate.printPart();
        cloned.printPart();
        deepCloned.printPart();
        shallowCloned.printPart();
        System.out.println("change content in the part of originate");originate.setPart();
        originate.printPart();
        cloned.printPart();
        deepCloned.printPart();
        shallowCloned.printPart();
        System.out.println("create a new part of originate");originate.createNewPart();
        originate.printPart();
        cloned.printPart();
        deepCloned.printPart();
        shallowCloned.printPart();
	}

}
