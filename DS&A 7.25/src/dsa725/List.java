package dsa725;

public interface List<e> {
	int size();
	
	boolean isEmpty();
	
	void addFront( e data);
	
	void addBack( e data);
	
	e get(int i) throws IllegalStateException;
	
	e set( int i, e data) throws IllegalStateException;
	
	e removeFront() throws IllegalStateException;
	
	e removeBack() throws IllegalStateException;
}
