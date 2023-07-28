package dsa624;

public class LinkedStack<e> implements Stack<e> {
	private SinglyLinkedList<e> stack = new SinglyLinkedList<>();
	
	public LinkedStack() {}
	
	public int size() { return stack.size();}
	
	public boolean isEmpty() { return stack.isEmpty();}
	
	public void push(e data) { stack.push(data);}
	
	public e pop() { return stack.pop();}
	
	public e top() { return stack.top();}
	
	public void print() { stack.print();}
	
	public e next() { return stack.next();}

}
