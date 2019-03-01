import java.util.*;

public class AustraliaCSP extends CSP {

	public AustraliaCSP(String name, ArrayList<Variable> variables, ArrayList<Constraint> constraints) {
		super(name, variables, constraints);
	} // end constructor

	public static void main(String[] args) {
		ArrayList<Value<?>> valuesList = new ArrayList<Value<?>>();
		valuesList.add(new Value<String>("Red"));
		valuesList.add(new Value<String>("Green"));
		valuesList.add(new Value<String>("Blue"));
		Domain domain = new Domain(valuesList);
		ArrayList<Variable> variables = new ArrayList<Variable>();
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
		ArrayList<Constraint> constraints = new ArrayList<Constraint>();
		ArrayList<Variable> variablesList = new ArrayList<Variable>();
		variablesList.add(SA);
		variablesList.add(WA);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList.clear();
		
		variablesList.add(SA);
		variablesList.add(NT);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList.clear();
		
		variablesList.add(SA);
		variablesList.add(Q);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList.clear();
		
		variablesList.add(SA);
		variablesList.add(NSW);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList.clear();
		
		variablesList.add(SA);
		variablesList.add(V);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList.clear();
		
		variablesList.add(NT);
		variablesList.add(WA);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList.clear();
		
		variablesList.add(NT);
		variablesList.add(Q);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList.clear();
		
		variablesList.add(Q);
		variablesList.add(NSW);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList.clear();
		
		variablesList.add(NSW);
		variablesList.add(V);
		constraints.add(new notEqualConstraint(variablesList));
		variablesList.clear();
		
		AustraliaCSP problem = new AustraliaCSP("AustraliaCSP", variables, constraints);
		Solver solution = new Solver(problem);
		solution.backTrackingSearch();
		for(Variable i : problem.getVars()) {
			System.out.println(i.getName() + " : " + i.getValue().getInstance());
		}
	} // end main method
} // end AustraliaCSP
