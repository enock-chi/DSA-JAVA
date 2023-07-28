package dsa625;

public class LinkedStack<e> implements Stack<e>{
	LinkedList<e> queue = new LinkedList<>();
	
	public LinkedStack() {}
	
	public int size() { return queue.size();}
	
	public boolean isEmpty() { return queue.isEmpty();}
	
	public e top() { return queue.top();}
	
	public e pop() { 
		for (int k = 0; k < queue.size() - 1; k++) {
			queue.push(queue.pop());
		}
		return queue.pop();
	}
	
	public void push(e data) { queue.push(data);}
	
	public void print() { queue.print();}

}
