package dsa711;
import java.util.Arrays;

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
		
		/**
		 * Returns the data 
		 * 
		 * @throws IllegalStateException, however I noticed if it's commented out there's
		 *         a certain error when editing the Positional list does't occur
		 * @return data
		 * */
		public e getData() throws IllegalStateException { 
			//if (next == null) throw new IllegalStateException("Position not available");
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
	
	private Node<e> validate(Position<e> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid Position");
		Node<e> node = (Node<e>) p;
		if (node.getNext() == null) throw new IllegalArgumentException("Postion not in list");
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
	
	public void print() {
		Node<e> curr = head.getNext();
		e[] arr = (e[]) new Object[size];
		for ( int k = 0; k < size; k++) {
			if( curr != null) {
				arr[k] = curr.getData();
			    curr = curr.getNext();
			}
			
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public LinkedPositionalList() {
		head = new Node<>( null, null, null);
		tail = new Node<>( null, head, null);
		head.setNext(tail);
	}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public Position<e> first(){ return position(head.getNext());}
	
	public Position<e> last(){ return position(tail.getPrev());}
	
	public Position<e> before(Position<e> p) throws IllegalArgumentException {
		Node<e> node = validate(p);
		return position(node.getPrev());
	}
	
	public Position<e> after(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return position(node.getNext());
	}
	
	
	public Position<e> addFirst(e data){ return addBetween(data,head,head.getNext());}
	
	public Position<e> addLast( e data){ return addBetween(data,tail.getPrev(), tail);}
	
	public Position<e>  addBefore(Position<e> p, e data) throws IllegalArgumentException{ 
		Node<e> node = validate(p);
		return addBetween(data,node.getPrev(),node);
	}
	
	public Position<e> addAfter(Position<e> p, e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return addBetween(data, node,node.getNext());
	}
	
	public e set(Position<e> p, e data) throws IllegalArgumentException {
		Node<e> node = validate(p);
		e prevData = node.getData();
		node.setData(data);
		return prevData;
	}
	
	public e remove(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		node.getNext().setPrev(node.getPrev());
		node.getPrev().setNext(node.getNext());
		node.setNext(null);
		node.setPrev(null);
		node.setData(null);
		size--;
		return node.getData();
	}
	

}
