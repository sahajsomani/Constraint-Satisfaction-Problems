public abstract class CSP { //abstract structure of our CSP
  private String name;
  private HashMap<String, Variable> variables;
  private ArrayList<Constraint> constraints;

  public CSP(String name, HashMap<Variable> variables, ArrayList<Constraint> constraints) {
    this.name = name;
    this.variables = variables;
    this.constraints = constraints;
  }

  public String getName() { return this.name; }

  public HashMap<Variable> getVars() { return this.variables; }

  public ArrayList<Constraint> getConst() { return this.constraints; }

  public void setName(String name) { this.name = name; }

  public void setVars(HashMap<Variable> variables) { this.variables = variables; }

  public void setConst(ArrayList<Constraint> constraints) { this.constraints = constraints; }
} //end class
