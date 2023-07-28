package dsa621;

public class LinkedStack<e> implements Stack<e>, Cloneable{
	private LinkedList<e> list = new LinkedList<>();
	
	public LinkedStack() {}
	
	public void push(e data) { list.add(data);}
	
	public e pop() { return list.pop();}
	
	public e top() { return list.first();}
	
	public boolean isEmpty() { return list.isEmpty();}
	
	public int size() { return list.size();}
	
	public void print() { list.print();}
	
	public void rotate() { list.rotate();}
	
	public e next() { return list.next();}
	
	public LinkedStack<e> clone() throws CloneNotSupportedException{
		LinkedStack<e> clonedStack = (LinkedStack<e>) super.clone();
		clonedStack.list = this.list.clone();
		return clonedStack;
	}

}
