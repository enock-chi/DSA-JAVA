package dsa716;

public interface Iterator<e> {
	boolean hasNext();
	
	e next();
	
	void remove() throws IllegalStateException;

}
