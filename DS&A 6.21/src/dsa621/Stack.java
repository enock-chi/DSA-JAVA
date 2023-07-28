package dsa621;

public interface Stack<e> {
	
	public void push( e data);
	
	public e pop();
	
	public boolean isEmpty();
	
	public int size();
	
	public e top();

}
