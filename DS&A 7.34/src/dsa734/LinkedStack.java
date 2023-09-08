package dsa734;
import java.util.*;

public class LinkedStack<e> implements Stack<e> {
	private LinkedList<e> list = new LinkedList<>();
	private int size = 0;
	
	public LinkedStack() {}
	
	public int size() { return list.size();}
	
	public boolean isEmpty() { return list.isEmpty();}
	
	public e top() { return list.first();}
	
	public void push(e data) { list.addLast(data);}
	
	public e pop() { return list.removeFirst();}
	
	public void print() { list.print();}
    
}
