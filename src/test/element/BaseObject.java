package test.element;

public class BaseObject {

	public BaseObject(String id) {
		super();
		this.id = id;
	}

	public BaseObject() {
		super();
	}

	private String id="2123123112";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
