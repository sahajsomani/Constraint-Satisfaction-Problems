import java.util.ArrayList;

public class JobSchedulingCSP extends CSP {

	public JobSchedulingCSP(String name, ArrayList<Variable> variables, ArrayList<Constraint> constraints) {
		super(name, variables, constraints);
	} // end constructor
	
	static class greaterThanConstraint extends Constraint {
		private Integer diff;
		
		public greaterThanConstraint(ArrayList<Variable> variablesList, Integer diff) {
			super(variablesList);
			this.diff = diff;
		} //end constructor
		
		public int getDiff() { return this.diff; }
		
		public void setDiff(int diff) { this.diff = diff; }

		@Override
		public boolean isSatisfied() {
			ArrayList<Variable> variablesList = this.getVarsList();
			Variable greater = variablesList.get(0);
			Variable smaller = variablesList.get(1);
			
			if(greater.getValue().getInstance() >= ((smaller.getValue().getInstance()) + this.diff)) {
				return true;
			} else {
				return false;
			}
		} //end isSatisfied
	} //end greaterThanConstraint
	
	public static void main(String[] args) {
		System.out.println("This is Australia map problem.");
		ArrayList<Value<?>> valuesList = new ArrayList<Value<?>>();
		for(int i = 1; i < 28; i++) {
			valuesList.add(new Value<Integer>(i));
		}
		Domain domain = new Domain(valuesList);
		ArrayList<Variable> variables = new ArrayList<Variable>();
		
		Variable axleF = new Variable("axleF", domain);
		variables.add(axleF);
		
		Variable axleB = new Variable("axleB", domain);
		variables.add(axleB);
		
		Variable wheelRF = new Variable("wheelRF", domain);
		variables.add(wheelRF);
		
		Variable wheelLF = new Variable("wheelLF", domain);
		variables.add(wheelLF);
		
		Variable wheelRB = new Variable("wheelRB", domain);
		variables.add(wheelRB);
		
		Variable wheelLB = new Variable("wheelLB", domain);
		variables.add(wheelLB);
		
		Variable nutsRF = new Variable("nutsRF", domain);
		variables.add(nutsRF);
		
		Variable nutsLF = new Variable("nutsLF", domain);
		variables.add(nutsLF);
		
		Variable nutsRB = new Variable("nutsRB", domain);
		variables.add(nutsRB);
		
		Variable nutsLB = new Variable("nutsLB", domain);
		variables.add(nutsLB);
		
		Variable capRF = new Variable("capRF", domain);
		variables.add(capRF);
		
		Variable capLF = new Variable("capLF", domain);
		variables.add(capLF);
		
		Variable capRB = new Variable("capRB", domain);
		variables.add(capRB);
		
		Variable capLB = new Variable("capLB", domain);
		variables.add(capLB);
		
		Variable inspect = new Variable("inspect", domain);
		inspect.setAssigned(true);
//		Integer temp = 28;
//		Value<Integer> twentyEight = temp;
//		inspect.setValue(twentyEight);
		variables.add(inspect);
		
		
		ArrayList<Constraint> constraints = new ArrayList<Constraint>();
		ArrayList<Variable> variablesList = new ArrayList<Variable>();
		variablesList.add(wheelRF);
		variablesList.add(axleF);
		Integer diff10 = 10;
		Integer diff1 = 1;
		Integer diff2 = 2;
		constraints.add(new greaterThanConstraint(variablesList, diff10));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(wheelLF);
		variablesList.add(axleF);
		constraints.add(new greaterThanConstraint(variablesList, diff10));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(wheelRB);
		variablesList.add(axleB);
		constraints.add(new greaterThanConstraint(variablesList, diff10));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(wheelLB);
		variablesList.add(axleB);
		constraints.add(new greaterThanConstraint(variablesList, diff10));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(nutsLF);
		variablesList.add(wheelLF);
		constraints.add(new greaterThanConstraint(variablesList, diff1));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(nutsRF);
		variablesList.add(wheelRF);
		constraints.add(new greaterThanConstraint(variablesList, diff1));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(nutsLB);
		variablesList.add(wheelLB);
		constraints.add(new greaterThanConstraint(variablesList, diff1));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(nutsRB);
		variablesList.add(wheelRB);
		constraints.add(new greaterThanConstraint(variablesList, diff1));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(capRF);
		variablesList.add(nutsRF);
		constraints.add(new greaterThanConstraint(variablesList, diff2));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(capLF);
		variablesList.add(nutsLF);
		constraints.add(new greaterThanConstraint(variablesList, diff2));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(capRB);
		variablesList.add(nutsRB);
		constraints.add(new greaterThanConstraint(variablesList, diff2));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(capLB);
		variablesList.add(nutsLB);
		constraints.add(new greaterThanConstraint(variablesList, diff2));
		variablesList = new ArrayList<Variable>();
		
		variablesList.add(axleF);
		variablesList.add(axleB);
		constraints.add(new greaterThanConstraint(variablesList, diff10));
		variablesList = new ArrayList<Variable>();
		
		JobSchedulingCSP problem = new JobSchedulingCSP("JobSchedulingCSP", variables, constraints);
		Solver solution = new Solver(problem);

		if(solution.backTrackingSearch()) {
			System.out.println("Solution: ");
			for(Variable i : problem.getVars()) {
				System.out.println(i.getName() + " : " + i.getValue().getInstance());
			}
		} else {
			System.out.println(problem.getName() +  " does not have a solution.");
		}
	} //end main
	
} //end JobSchedulingCSP
