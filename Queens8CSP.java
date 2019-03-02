import java.util.*;

public class Queens8CSP extends CSP {
	
	public Queens8CSP(String name, ArrayList<Variable> variables, ArrayList<Constraint> constraints) {
		super(name, variables, constraints);
	}
	
	static class notAttackingConstraint extends Constraint {
		
		public notAttackingConstraint(ArrayList<Variable> variablesList) {
			super(variablesList);
		}
		
		public boolean isSatisfied() {
			ArrayList<Variable> variablesList = this.getVarsList();
			for(int i = 0; i < variablesList.size(); i++) {
				for(int j = i + 1; j < variablesList.size(); j++) {
					Variable A = variablesList.get(i);
					Variable B = variablesList.get(j);
					if(A.getAssigned() && B.getAssigned()) {
						if(A.getValue().compareTo(B.getValue()) == 0) {
							return false;
						}
					}
				}
			}
			return true;
		}
	}
	
	static class Location implements Comparable<Location> {
		private int x;
		private int y;
		
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() { return this.x; }
	
		public int getY() { return this.y; }
		
		public void setX(int x) { this.x = x; }
		
		public void setY(int y) { this.y = y; }
		
		public String toString() {
			return Integer.toString(this.y);
		}
		
		public int compareTo(Location that) {
			if(this.getX() == that.getX()) { return 0; }
			if(this.getY() == that.getY()) { return 0; }
			if(Math.abs(this.getX() - that.getX()) == Math.abs(this.getY() - that.getY())) { return 0; }
			return 1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("This is 8 Queens problem.");
		System.out.print("Please enter the amount of Queens: ");
		Scanner scanner = new Scanner(System.in);
		int numOfQueens = scanner.nextInt();
		scanner.close();
		ArrayList<Variable> variables = new ArrayList<Variable>();
		ArrayList<Constraint> constraints = new ArrayList<Constraint>();
		for(int i = 1; i <= numOfQueens; i++) {
			ArrayList<Value<?>> valuesList= new ArrayList<Value<?>>();
			for(int j = 1; j <= numOfQueens; j++) {
				Value<Location> value = new Value<Location>(new Location(i, j));
				valuesList.add(value);
			}
			Domain domain = new Domain(valuesList);
			Variable variable = new Variable(Integer.toString(i), domain);
			variables.add(variable);
		}
		constraints.add(new notAttackingConstraint(variables));
		Queens8CSP problem = new Queens8CSP("Queens8CSP", variables, constraints);
		Solver solution = new Solver(problem);
		
		if(solution.backTrackingSearch()) {
			System.out.println("Solution: ");
			for(Variable i : problem.getVars()) {
				System.out.println(i.getName() + " : " + i.getValue().getInstance());
			}
		} else {
			System.out.println(problem.getName() +  " does not have a solution.");
		}
	}
}
