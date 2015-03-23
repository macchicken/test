package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import test.element.Product;

public class XmlDomDemo {

	private static Document document;
	
	private static void init() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void parserXml(String fileName) {
		ArrayList<Product> stores=new ArrayList<Product>();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(fileName);
			NodeList employees = document.getChildNodes();
			for (int i = 0; i < employees.getLength(); i++) {
				Node employee = employees.item(i);
				NodeList employeeInfo = employee.getChildNodes();
				System.out.println("employeeInfo len: "+employeeInfo.getLength());
				for (int j = 0; j < employeeInfo.getLength(); j++) {
					Product p=new Product();
					Node node = employeeInfo.item(j);
					NodeList employeeMeta = node.getChildNodes();
					for (int k = 0; k < employeeMeta.getLength(); k++) {
						String nodeName=employeeMeta.item(k).getNodeName();
						String content=employeeMeta.item(k).getTextContent().trim();
						try {
							Field field=p.getClass().getDeclaredField(nodeName);
							if (field!=null) {
								field.setAccessible(true);
								System.out.println(field.getType().getName());
								if (field.getType().getName().equals("float")){
									field.set(p, Float.parseFloat(content));
								}else if(field.getType().getName().equals("int")){
									field.set(p, Integer.parseInt(content));
								}else{
									field.set(p, content);
								}
							}
						} catch (IllegalArgumentException e) {
							continue;
						} catch (IllegalAccessException e) {
							continue;
						} catch (NoSuchFieldException e) {
							continue;
						} catch (SecurityException e) {
							continue;
						}
					}
					if (employeeMeta.getLength()>0) {
						stores.add(p);
						System.out.println(p);
					}
				}
			}
			System.out.println("Ω‚ŒˆÕÍ±œ");
			System.out.println(stores.size());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		parserXml("src\\test\\products.xml");
	}

}
