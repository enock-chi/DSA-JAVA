package dsa72;

import java.util.*;

public class StackADT<e> implements Stack<e> {
	ArrayList<e> stack = new ArrayList<>();
	
	public StackADT() {}
	
	public int size() { return stack.size();}
	
	public boolean isEmpty() { return (stack.size() == 0);}
	
	public void push(e data) { stack.add(0,data);}
	
	public e pop() { return stack.remove(0);}
	
	public e first() { return stack.get(0);}
	
	public void print() { System.out.println(stack.toString());}

}
