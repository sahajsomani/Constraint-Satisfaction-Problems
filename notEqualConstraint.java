import java.util.*;

public class notEqualConstraint extends Constraint {

	public notEqualConstraint(ArrayList<Variable> variablesList) {
		super(variablesList);
	} // end constructor

	public boolean isSatisfied() {
		ArrayList<Variable> variablesList = this.getVarsList();
		for(int i = 0; i < variablesList.size(); i++) {
			for(int j = i + 1; j < variablesList.size(); j++) {
				Variable a = variablesList.get(i);
				Variable b = variablesList.get(j);
				if(a.getValue().compareTo(b.getValue()) == 1) {
					return false;
				}
			}
		}
		return true;
	} // end isSatisfied

} // end class
