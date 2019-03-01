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

	public void backTrackingSearch() {
		if (this.completeAssignment()) {
			return;
		}
		Variable variable = this.selectUnassignedVariable();
		System.out.println(variable.getName());
		Domain domain = variable.getDomain();
		ArrayList<Value<?>> values = domain.getValuesList();
		this.amountAssigned++;
		for (Value<?> value : values) {
			variable.setValue(value);
			if (this.isConsistent()) {
				this.backTrackingSearch();
			} else {
				variable.setValue(null);
			}
		}
		variable.setAssigned(false);
		this.amountAssigned--;
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
