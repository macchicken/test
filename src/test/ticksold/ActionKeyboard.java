package test.ticksold;

public class ActionKeyboard implements Keyboard {

	private String selectedKey="";

	public void setSelectedKey(String selectedKey) {
		this.selectedKey = selectedKey;
	}

	@Override
	public int getSelectedKey() {
		return 0;
	}
	
	public int getAction(){
		return selectedKey.equals("cancel")?0:1;
	}

}
