package dsa627;

public interface Stack<e> {
	int size();
	
	boolean isEmpty();
	
	e top();
	
	e pop();
	
	void push(e data);

}
