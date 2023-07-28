package dsa625;

public interface Stack<e> {
	
	int size();
	
	boolean isEmpty();
	
	void push(e data);
	
	e top();
	
	e pop();

}
