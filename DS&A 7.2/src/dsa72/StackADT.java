package dsa72;

import java.util.*;

public class StackADT<e> implements Stack<e> {
	Arraylist<e> stack = new Arraylist<>();
	
	public StackADT() {}
	
	public int size() { return stack.size();}
	
	public boolean isEmpty() { return (stack.size() == 0);}
	
	public void push(e data) { stack.add(stack.size(),data);}
	
	public e pop() { return stack.remove(stack.size()-1);}
	
	public e first() { return stack.get(0);}
	
	public void print() { stack.print();}

}
