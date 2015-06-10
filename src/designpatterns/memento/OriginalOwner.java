package designpatterns.memento;

class OriginalOwner {


	private String state;

	public void setState(String state) {
		System.out.println("Originator: Setting state to "+state);
		this.state = state;
	}
	
	public Memento saveToMemento(){
		System.out.println("create current state '"+state+"' to a Memento to store the saved data ");
		return new Memento(state);
	}

	public void restoreFromMemento(Memento mem){
		System.out.println("recover data from a Memento "+mem);
		this.state=mem.getSavedState();
	}

	@Override
	public String toString() {
		return "OriginalOwner [state=" + state + "]";
	}

	class Memento{
		private String state;

		private String getSavedState() {
			return state;
		}
		
		private Memento(String state) {
			this.state = state;
		}

		@Override
		public String toString() {
			return "Memento [state=" + state + "]";
		}

	}

}
