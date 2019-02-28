public class notEqualConstraint extends Constraint {

  public notEqualConstraint(Variable one, Variable two) {
    ArrayList<Variable> variablesList = new ArrayList<Variable>();
    variablesList.add(one);
    variablesList.add(two);
    super(variablesList);
  } //end constructor

  public boolean isSatisfied() {
    Variable a = this.getVarsList().get(0);
    Variable b = this.getVarsList().get(1);
    if(a.getValue().compareTo(b.getValue()) == 0) {
      return true;
    }
    return false;
  } //end isSatisfied
  
} //end class
