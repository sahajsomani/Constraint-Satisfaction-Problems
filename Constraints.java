import java.util.*;

public abstract class Constraint { // abstract structure of Constraint class
	private ArrayList<Variable> variablesList; // names variablesList so that we dont confuse it with the variables in CSP class

	public Constraint(ArrayList<Variable> variablesList) {
		this.variablesList = variablesList;
	} // end constructor

	public ArrayList<Variable> getVarsList() { return this.variablesList; }

	public void setVarsList(ArrayList<Variable> variablesList) { this.variablesList = variablesList; }

	public abstract boolean isSatisfied();

} // end class
