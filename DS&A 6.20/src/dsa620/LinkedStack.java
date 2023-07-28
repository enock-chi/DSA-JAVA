package dsa620;

public class LinkedStack<e> implements Stack<e> {
	private LinkedList list = new LinkedList<>();
	
	public LinkedStack() {}
	
	public void push(e data) { list.add(data);}
	
	public e pop() { return (e) list.remove();}
	
	public e top() { return (e)list.first();}
	
	public boolean isEmpty() { return list.isEmpty();}
	
	public int Size() { return list.getSize();}
	
	public void print() { list.print();}

}
