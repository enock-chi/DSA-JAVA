package dsa718;

public interface List<e> {
	int size();
	
	boolean isEmpty();
	
	public void add(int i,e data) throws IndexOutOfBoundsException;
	
	e remove(int i) throws IndexOutOfBoundsException;
	
	e get(int i) throws IndexOutOfBoundsException;
	
	e set(int i, e data) throws IndexOutOfBoundsException;
}
