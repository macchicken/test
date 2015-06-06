package designpatterns.ood.practices.week8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class IDCardFactory extends Factory {

	private int serialNum;
	private List<IDCard> cards=new LinkedList<IDCard>();
	private Map<String,Integer> usrIDS=new HashMap<String,Integer>();
	
	IDCardFactory() {
		serialNum=0;
	}

	@Override
	protected Product createProduct(String owner) {
		serialNum+=1;
		IDCard card=new IDCard(owner,serialNum);
		return card;
	}

	@Override
	protected void registerProduct(Product product) {
		usrIDS.put(((IDCard) product).getOwner(), ((IDCard) product).getSerialNumber());
		cards.add((IDCard) product);
	}

	List<String> getOwners() {
		List<String> owners = new LinkedList<String>();
		cards.forEach(idCard->owners.add(idCard.getOwner()));
		return owners;
	}

}
