package dsa623;

public class LinkedQueue<e> {
	private CircleList<e> queue = new CircleList<>();
	
	public LinkedQueue() {}
	
	public void queue(e data) { queue.queue(data);}
	
	public e dequeue() { return (e)queue.dequeue();}
	
	public e first() { return (e)queue.first();}
	
	public int size() { return queue.size();}
	
	public boolean isEmpty() { return queue.isEmpty();}
	
	public void print() { queue.print();}
	
	public void rotate() { queue.rotate();}

}
