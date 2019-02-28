public class AustraliaCSP extends CSP {

  public AustraliaCSP(String name, HashMap<Variable> variables, ArrayList<Constraint> constraints)
    super(name, variables, constraints);
  } //end constructor

  class State extends Variable {

    public State(String name, Domain domain) {
      super(String name, Domain domain);
    }

  }


  public static void main(String[] args) {

  } //end main method
} //end AustraliaCSP
