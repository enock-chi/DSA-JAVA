package dsa624;

public class DoublyQueue<e> implements Queue<e>{
	private DoublyLinkedList<e> queue = new DoublyLinkedList<>();
	
	public DoublyQueue() {}
	
	public int size() { return queue.size();}
	
	public boolean isEmpty() { return queue.isEmpty();}
	
	public void queue(e data) { queue.queue(data);}
	
	public e dequeue() { return queue.dequeue();}
	
	public e first() { return queue.first();}
	
	public void print() { queue.print();}
	
	public boolean scan(LinkedStack<e> stack, e element) { return queue.scan(stack, element);}

}
