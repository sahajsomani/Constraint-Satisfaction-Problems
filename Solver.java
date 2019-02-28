public class Solver {
  private CSP csp;
  private HashMap<String, String> solution;

  public Solver(CSP csp) {
    this.csp = csp;
    this.solution = new HashMap<String, String>();
    this.stack = new Stack<Variable>();
  } //end constructor

  public CSP getCSP() { return this.csp; }

  public void setCSP(CSP csp) { this.csp = csp; }

  public HashMap<String, String> getSolution() {
    if(this.completeAssignment()) {
      return this.solution;
    } else {
      System.out.println(this.csp.getName + " has no solution.");
      return new HashMap<String, String>();
    }
  }

  public void backTrackingSearch() {
    if(this.completeAssignment(csp)) {
      return;
    }

    Variable variable = this.selectUnassignedVariable();
    Domain domain = variable.getDomain();
    ArrayList<Object implements Comparable> values = domain.getList();
    for(Object value : values) {
      variable.setValue(value);
        if(this.isConsistent()) {
          this.backTrackingSearch();
        } else {
          variable.setValue(null);
        }
    }
    return;
  } //end backtrackingSearch

  private boolean completeAssignment() {
    return (this.csp.getVars().size() == this.solution.size());
  } //end completeAssignment

  private Variable selectUnassignedVariable() {
    Collection<Variable> variables = this.csp.getVars().values();
    for(Variable variable : variables) {
      if(!variable.getAssigned) {
        return variable;
      }
    }
  } //end selectUnassignedVariable

  private boolean isConsistent() {
    ArrayList<Constraint> constraints = this.csp.getConst();
    for(Constraint constraint : constraints) {
      if(!constraint.isSatisfied()) {
        return false;
      }
    }
    return true;
  } //end isConsistent

} //end class
