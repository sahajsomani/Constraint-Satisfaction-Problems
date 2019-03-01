
public class Value<T extends Comparable<T>> implements Comparable<Value<?>> { //Value class
	private T instance;

	public Value(T instance) {
		this.instance = instance;
	} // end constructor

	public T getInstance() { return this.instance; }

	public void setValue(T value) { this.instance = value; }

	@SuppressWarnings("unchecked")
	public int compareTo(Value<?> that) {
		return this.instance.compareTo((T) that.getInstance());
	}
} // end class
