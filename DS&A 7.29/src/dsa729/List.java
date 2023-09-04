package dsa729;

public interface List<e> {
	int size();
	
	boolean isEmpty();
	
	e get(int i) throws IndexOutOfBoundsException;
	
	e set(int i , e data) throws IndexOutOfBoundsException;
	
	public void add( int i, e data) throws IndexOutOfBoundsException;
	
	public e remove(int i) throws IndexOutOfBoundsException;

}
