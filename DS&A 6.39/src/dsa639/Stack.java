package dsa639;

public interface Stack<e> {
	int size();
	
	boolean isEmpty();
	
	void push( e data);
	
	e pop();
	
	e top();

}
