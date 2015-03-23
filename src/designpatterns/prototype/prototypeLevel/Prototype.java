package designpatterns.prototype.prototypeLevel;

import java.io.Serializable;

public interface Prototype extends Cloneable,Serializable {

	public Object clone();
}
