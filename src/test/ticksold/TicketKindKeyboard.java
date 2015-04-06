package test.ticksold;

public class TicketKindKeyboard implements Keyboard {

	private String selectedKey="";

	public void setSelectedKey(String selectedKey) {
		this.selectedKey = selectedKey;
	}

	@Override
	public int getSelectedKey() {
		return 0;
	}
	
	public String getTicketKind(){
		return selectedKey;
	}

}
