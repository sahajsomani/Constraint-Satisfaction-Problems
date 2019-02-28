public abstract class Variable {
  private String name;
  private Domain domain;
  private boolean assigned;
  private Object value;

  public Variable(String name, Domain domain) {
    this.name = name;
    this.domain = domain;
    this.assigned = false;
    this.value = null;
  } //end constructor

  public String getName() { return this.name; }

  public Domain getDomain() { return this.domain; }

  public boolean getAssigned() { return this.assigned; }

  public Object getValue() { return this.value; }

  public void setName(String name) { this.name = name; }

  public void setDomain(Domain domain) { this.domain = domain; }

  public void setAssigned(boolean assigned) { this.assigned = assigned; }

  public void setValue(Object value) { this.value = value; }
} //end class
