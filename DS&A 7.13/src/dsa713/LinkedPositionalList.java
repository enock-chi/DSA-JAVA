package dsa713;

public class LinkedPositionalList<e> implements PositionalList<e>{
//===================================================
	private static class Node<e> implements Position<e>{
		private e data;
		private Node<e> prev;
		private Node<e> next;
		
		public Node(e data, Node<e> prev, Node<e> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public e getData() throws IllegalStateException {
			if (next == null) throw new IllegalStateException("Position not valid");
			return data;
		}
		
		public Node<e> getNext(){ return next;}
		
		public Node<e> getPrev(){ return prev;}
		
		public void setData( e data) { this.data = data;}
		
		public void setNext(Node<e> next) { this.next = next;}
		
		public void setPrev(Node<e> prev) { this.prev = prev;}
		
	}
//===================================================
	private Node<e> head;
	private Node<e> tail;
	private int size;
	
	private Node<e> validate(Position<e> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid Position");
		Node<e> node = (Node<e>) p;
		if (node.getNext() == null) throw new IllegalArgumentException("Position not in list");
		return node;
	}
	
	private Position<e> position(Node<e> n){
		if (tail == n || head == n) return null;
		return n;
	}
	
	private Position<e> addBetween(e data, Node<e> prev, Node<e> next){
		Node<e> newest = new Node<>(data,prev,next);
		prev.setNext(newest);
		next.setPrev(newest);
		size++;
		return newest;
	}
	
	public LinkedPositionalList() {
		head = new Node<>(null,null,null);
		tail= new Node<>(null,head,null);
		head.setNext(tail);
	}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public Position<e> first(){ return position(head.getNext());}
	
	public Position<e> last(){ return position(tail.getPrev());}
	
	public Position<e> before(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return position(node.getPrev());
	}
	
	public Position<e> after(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return position(node.getNext());
	}
	
	public Position<e> addFirst(e data){
		return addBetween(data,head,head.getNext());
	}
	
	public Position<e> addLast(e data){
		return addBetween(data,tail.getPrev(),tail);
	}
	
	public Position<e> addBefore(Position<e> p,e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return addBetween(data,node.getPrev(), node);
	}
	
	public Position<e> addAfter(Position<e> p, e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return addBetween(data,node,node.getNext());
	}
	
	public e set(Position<e> p, e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		e output = node.getData();
		node.setData(data);
		return output;
	}
	
	public e remove(Position<e> p)  throws IllegalArgumentException{
		Node<e> node = validate(p);
		e output = node.getData();
		node.getNext().setPrev(node.getPrev());
		node.getPrev().setNext(node.getNext());
		node.setData(null);
		node.setNext(null);
		node.setPrev(null);
		size--;
		return output;
	}

}
