package dsa711;

public class LinkedPositionalList<e> implements PositionalList<e> {
	private static class Node<e> implements Position<e>{
		private e data;
		private Node<e> next;
		private Node<e> prev;
		
		public Node(e data, Node<e> prev, Node<e> next) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		public e getData() throws IllegalStateException { 
			if (next == null) throw new IllegalStateException("Position not available");
			return data;
		}
		
		public void setData(e data) { this.data = data;}
		
		public void setNext(Node<e> next) { this.next = next;}
		
		public void setPrev(Node<e> prev) { this.prev = prev;}
		
		public Node<e> getNext(){ return next;}
		
		public Node<e> getPrev(){ return prev;}
	}
	private Node<e> head;
	private Node<e> tail;
	private int size = 0;
	
	private Node<e> validate(Position<e> p) throws IllegalStateException{
		if (!(p instanceof Node)) throw new IllegalStateException("Invalid Position");
		Node<e> node = (Node<e>) p;
		if (node.getNext() == null) throw new IllegalStateException("Postion not in list");
		return node;
	}
	
	private Position<e> position(Node<e> node){
		if (node == head || node == tail) return null;
		return node;
	}
	
	private Position<e> addBetween(e data, Node<e> prev, Node<e> next){
		Node<e> newest = new Node<>(data, prev,next);
		next.setPrev(newest);
		prev.setNext(newest);
		size++;
		return newest;
	}
	
	public LinkedPositionalList() {
		head = new Node<>( null, null, null);
		tail = new Node<>( null, head, null);
		head.setNext(tail);
	}
	
	

}
