package dsa623;

public interface Stack<e> {
	
	e pop();
	
	void push(e data);
	
	int size();
	
	boolean isEmpty();
	
	e top();

}
