package test.ticksold;

public class DestinnationKeyboard implements Keyboard {

	private int selectedKey;

	public void setSelectedKey(int selectedKey) {
		this.selectedKey = selectedKey;
	}

	@Override
	public int getSelectedKey() {
		return selectedKey;
	}

	public String getDestinationCode(){
		return String.valueOf(selectedKey);
	}
}
