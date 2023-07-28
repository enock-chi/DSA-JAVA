package dsa639;

public class LinkedStack<e> implements Stack<e>{
	private LinkedList<e> stack ;
	
	public LinkedStack() {stack = new LinkedList<>();}
	
	public LinkedStack(int cap) {stack = new LinkedList<>(cap);}
	
	public int size() { return stack.size();}
	
	public boolean isEmpty() { return stack.isEmpty();}
	
	public void push(e data) { stack.push(data);}
	
	public e pop() { return stack.pop();}
	
	public e top() { return stack.top();}
	
	public void print() { stack.print();}

}
