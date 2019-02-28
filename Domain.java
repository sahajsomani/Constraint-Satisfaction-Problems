public abstract class Domain {
  private ArrayList<Object implements Comparable> list;

  public Domain(ArrayList<Object implements Comparable> list) {
    this.list = list;
  }

  public ArrayList<Object implements Comparable> getList() { return this.list; }

  public void setList(ArrayList<Object implements Comparable>) { this.list = list; }
} //end class
