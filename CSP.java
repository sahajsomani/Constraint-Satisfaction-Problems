import java.util.*;

public abstract class CSP { // abstract structure of our CSP
	private String name;
	private ArrayList<Variable> variables;
	private ArrayList<Constraint> constraints;
import java.util.*;

public abstract class CSP { // abstract structure of our CSP
	private String name;
	private ArrayList<Variable> variables;
	private ArrayList<Constraint> constraints;

	public CSP(String name, ArrayList<Variable> variables, ArrayList<Constraint> constraints) {
		this.name = name;
		this.variables = variables;
		this.constraints = constraints;
	} // end constructor

	public String getName() { return this.name; }

	public ArrayList<Variable> getVars() { return this.variables; }

	public ArrayList<Constraint> getConst() { return this.constraints; }

	public void setName(String name) { this.name = name; }

	public void setVars(ArrayList<Variable> variables) { this.variables = variables; }

	public void setConst(ArrayList<Constraint> constraints) { this.constraints = constraints; }
} // end class

	public CSP(String name, ArrayList<Variable> variables, ArrayList<Constraint> constraints) {
		this.name = name;
		this.variables = variables;
		this.constraints = constraints;
	} // end constructor

	public String getName() { return this.name; }

	public ArrayList<Variable> getVars() { return this.variables; }

	public ArrayList<Constraint> getConst() { return this.constraints; }

	public void setName(String name) { this.name = name; }

	public void setVars(ArrayList<Variable> variables) { this.variables = variables; }

	public void setConst(ArrayList<Constraint> constraints) { this.constraints = constraints; }
} // end class
