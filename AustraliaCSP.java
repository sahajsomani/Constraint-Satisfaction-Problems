import java.util.*;

public class AustraliaCSP extends CSP { // AustraliaCSP class contains the defintion for Australia problem. 
	//running the main method returns the solution to the problem

	public AustraliaCSP(String name, ArrayList<Variable> variables, ArrayList<Constraint> constraints) {
		super(name, variables, constraints);
	} // end constructor

	static class notEqualConstraint extends Constraint { // Australia specific constraint

		public notEqualConstraint(ArrayList<Variable> variablesList) {
			super(variablesList);
		} // end constructor

		public boolean isSatisfied() {
			ArrayList<Variable> variablesList = this.getVarsList();
			for(int i = 0; i < variablesList.size(); i++) {
				for(int j = i + 1; j < variablesList.size(); j++) {
					Variable a = variablesList.get(i);
					Variable b = variablesList.get(j);
					if(a.getAssigned() && b.getAssigned()) {
						if(a.getValue().compareTo(b.getValue()) == 0) {
							return false;
						}
					}
				}
			}
			return true;
		} // end isSatisfied

	} // end class
	
	public static void main(String[] args) { // main method... problem definitions and initialization
		System.out.println("This is Australia map problem.");
		ArrayList<Value<?>> valuesList = new ArrayList<Value<?>>(); // list of values
		valuesList.add(new Value<String>("Red")); 
		valuesList.add(new Value<String>("Green"));
		valuesList.add(new Value<String>("Blue"));
		Domain domain = new Domain(valuesList);
		ArrayList<Variable> variables = new ArrayList<Variable>(); // list of variables
		Variable WA = new Variable("WA", domain);
		variables.add(WA);
		Variable NT = new Variable("NT", domain);
		variables.add(NT);
		Variable Q = new Variable("Q", domain);
		variables.add(Q);
		Variable NSW = new Variable("NSW", domain);
		variables.add(NSW);
		Variable V = new Variable("V", domain);
		variables.add(V);
		Variable SA = new Variable("SA", domain);
		variables.add(SA);
		Variable T = new Variable("T", domain);
		variables.add(T);
		ArrayList<Constraint> constraints = new ArrayList<Constraint>(); // list of constraints
		ArrayList<Variable> variablesList = new ArrayList<Variable>();
		variablesList.add(SA);
		variablesList.add(WA);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(SA);
		variablesList.add(NT);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(SA);
		variablesList.add(Q);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(SA);
		variablesList.add(NSW);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(SA);
		variablesList.add(V);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(NT);
		variablesList.add(WA);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(NT);
		variablesList.add(Q);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(Q);
		variablesList.add(NSW);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(NSW);
		variablesList.add(V);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList = new ArrayList<Variable>();
		
		AustraliaCSP problem = new AustraliaCSP("AustraliaCSP", variables, constraints);
		Solver solution = new Solver(problem); // solver

		if(solution.backTrackingSearch()) { // printing the solution
			System.out.println("Solution: ");
			for(Variable i : problem.getVars()) {
				System.out.println(i.getName() + " : " + i.getValue().getInstance());
			}
		} else {
			System.out.println(problem.getName() +  " does not have a solution.");
		}
	} // end main method
} // end AustraliaCSP
