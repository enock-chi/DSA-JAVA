package dsa727;

public interface List<e> {
	int size();
	
	boolean isEmpty();
	
	void addFront(e data) throws IllegalStateException;
	
	void addBack(e data) throws IllegalStateException;
	
	e removeFront() throws IllegalStateException;
	
	e removeBack() throws IllegalStateException;
	
	e set(int i, e data) throws IllegalStateException;

}
