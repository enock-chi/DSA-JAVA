package dsa623;

public class LinkedStack<e> {
	private LinkedList<e> stack = new LinkedList<>();
	
	public LinkedStack() {}
	
	public void push(e data) { stack.push(data);}
	
	public e pop() { return stack.pop();}
	
	public e top() { return stack.top();}
	
	public int size() { return stack.size();}
	
	public boolean isEmpty() { return stack.isEmpty();}
	
	public void print() { stack.print();}

}
