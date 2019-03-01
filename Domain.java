import java.util.*;

public class Domain { // abstract structure of Domain class
	private ArrayList<Value<?>> valuesList;

	public Domain(ArrayList<Value<?>> valuesList) {
		this.valuesList = valuesList;
	} // end constructor

	public ArrayList<Value<?>> getValuesList() { return this.valuesList; }

	public void setValuesList(ArrayList<Value<?>> valuesList) { this.valuesList = valuesList; }
} // end class

