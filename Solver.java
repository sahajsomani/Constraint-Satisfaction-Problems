import java.util.*;

public class Solver { // Solver class
	private CSP csp;
	private int amountAssigned;

	public Solver(CSP csp) {
		this.csp = csp;
		this.amountAssigned = 0;
	} // end constructor

	public CSP getCSP() { return this.csp; }

	public void setCSP(CSP csp) { this.csp = csp; }

	public int backTrackingSearch() {
		if (this.completeAssignment()) {
			return 1; 
		}
		Variable variable = this.selectUnassignedVariable();
		Domain domain = variable.getDomain();
		ArrayList<Value<?>> values = domain.getValuesList();
		this.amountAssigned++;
		for (Value<?> value : values) {
			variable.setValue(value);
			System.out.println(variable.getName() + " : " + variable.getValue().getInstance() + " : " + this.isConsistent());
			if (this.isConsistent()) {
				return backTrackingSearch();
			}
		}
		variable.setValue(null);
		variable.setAssigned(false);
		this.amountAssigned--;
		return 0;
	} // end backtrackingSearch

	private boolean completeAssignment() {
		return (this.csp.getVars().size() == this.amountAssigned);
	} // end completeAssignment

	private Variable selectUnassignedVariable() {
		ArrayList<Variable> variables = this.csp.getVars();
		for (Variable variable : variables) {
			if (!variable.getAssigned()) {
				variable.setAssigned(true);
				return variable;
			}
		}
		return null;
	} // end selectUnassignedVariable

	private boolean isConsistent() {
		ArrayList<Constraint> constraints = this.csp.getConst();
		for (Constraint constraint : constraints) {
			if (!constraint.isSatisfied()) {
				return false;
			}
		}
		return true;
	} // end isConsistent

} // end class
