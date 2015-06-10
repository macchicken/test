package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class TestSerialize {

	private static Object deserialize(String fileName) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	// serialize the given object and save it to file
	private static void serialize(Object obj, String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		fos.close();
	}

	public static void main(String[] args) {
		String fileName="serializeTestObj.ser";
		SerializeTestObj emp = new SerializeTestObj();
		emp.setName("Pankaj");
		
		//serialize to file
		try {
			serialize(emp, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		SerializeTestObj empNew = null;
		try {
			empNew = (SerializeTestObj) deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println("emp Object::"+emp);
		System.out.println("empNew Object::"+empNew);
		System.out.println(emp.equals(empNew));
	}

}
