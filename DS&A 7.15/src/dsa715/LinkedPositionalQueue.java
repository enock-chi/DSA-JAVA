package dsa715;

public class LinkedPositionalQueue<e> implements PositionalQueue<e> {
//=============================================
	private static class Node<e> implements Position<e> {
		private  e data;
		private Node<e> next;
		private Node<e> prev;
		
		public Node(e data, Node<e> prev, Node<e> next) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		public e getData() { return data;}
		
		public Node<e> getNext(){ return next;}
		
		public Node<e> getPrev(){ return prev;}
		
		public void setNext(Node<e> next) { this.next = next;}
		
		public void setPrev(Node<e> prev) { this.prev = prev;}
		
		public void setData(e data) { this.data = data;}
	}
//=============================================
	private Node<e> head = new Node<>(null,null, null);
	private Node<e> tail = new Node<>(null,null, null);
	private int size = 0;
	
	private Node<e> validate(Position<e> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid Position");
		Node<e> node = (Node<e>) p;
		if (node.getNext() == null) throw new IllegalArgumentException("Position not available");
		return node;
	}
	
	private Position<e> position(Node<e> node) throws IllegalArgumentException{
		if (node == tail || node == tail) return null;
		return node;
	}
	
	public LinkedPositionalQueue() {}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public Position<e> enqueue(e data){
		Node<e> newest = new Node<>(data,null, null);
		if (isEmpty()) {
			tail = newest;
		} else {
			newest.setNext(head);
		}
		head = newest;
		size++;
		return newest;
	}
	
	public e remove() {
		if (isEmpty()) return null;
		Node<e> out = head;
		head = head.getNext();
		out.setNext(null);
		size--;
		return out.getData();
	}
	
	public e remove(Position<e> p) throws IllegalArgumentException{
		Node<e> out = validate(p);
		
		return out.getData();
	}
	
}
