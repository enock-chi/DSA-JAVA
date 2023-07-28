package dsa629;

public class LinkedQueue<e> implements Queue<e> {
	private LinkedList<e> queue = new LinkedList<>();
	
	public LinkedQueue() {}
	
	public int size() { return queue.size() ;}
	
	public boolean isEmpty() { return queue.isEmpty();}
	
	public void enqueue(e data) { queue.push(data);}
	
	public e dequeue() { return queue.pop();}
	
	public e first() { return queue.top();}
	
	public void print() { queue.print();}
	
	public void concatenate(LinkedQueue<e> q) { queue.concatenate(q);}

}
