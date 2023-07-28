package dsa75;

public interface List<e> {
	int size();
	
	boolean isEmpty();
	
	e get(int i);
	
	e set(int i, e data) throws IndexOutOfBoundsException;
	
	void add(int i, e data) throws IndexOutOfBoundsException, IllegalStateException;
	
	e remove(int i) throws IndexOutOfBoundsException;

}
