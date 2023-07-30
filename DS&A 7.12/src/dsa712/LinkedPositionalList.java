package dsa712;
import java.util.*;

public class LinkedPositionalList<e> implements PositionalList<e> {
//======================================================================
	public static class Node<e> implements Position<e>{
		e data;
		Node<e> next;
		Node<e> prev;
		
		public Node(e data, Node<e> prev, Node<e> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public e getData() throws IllegalStateException { return data;}
		
		public void setData( e data) { this.data = data;}
		
		public void setNext(Node<e> next) { this.next = next;}
		
		public void setPrev(Node<e> prev) { this.prev = prev;}
		
		public Node<e> getNext(){ return next;}
		
		public Node<e> getPrev(){ return prev;}
	}
//=======================================================================
	private Node<e> head ;
	private Node<e> tail ;
	private int size = 0;
	
	private Node<e>  validate(Position<e> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid Position");
		Node<e> node = (Node<e>) p;
		if (node.getNext() == null) throw new IllegalArgumentException("Position Not in List");
		return node;
	}
	
	private Position<e> position(Node<e> n){
		if ( head == n || tail == n) return null;
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
		tail = new Node<>(null,head,null);
		head.setNext(tail);
	}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public Position<e> first(){ return position(head.getNext());}
	
	public Position<e> last(){ return position(tail.getPrev());}
	
	public Position<e> addFirst(e data) {
		return addBetween(data, head, head.getNext());
	}
	
	public Position<e> addLast(e data) {
		return addBetween(data, tail.getPrev(), tail);
	}
	
	public Position<e> before(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return node.getPrev();
	}
	
	public Position<e> after(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return node.getNext();
	}
	
	public Position<e> addBefore(Position<e> p, e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		print();
		return addBetween(data, node.getPrev(), node);
	}
	
	public Position<e> addAfter(Position<e> p, e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		print();
		return addBetween(data,node,node.getNext());
	}
	
	public e set(Position<e> p, e data) throws IllegalArgumentException {
		Node<e> element = validate(p);
		e output = element.getData();
		element.setData(data);
		System.out.println(output);
		print();
		return output;
	}
	
	public e remove(Position<e> p) throws IllegalArgumentException {
		Node<e> node = validate(p);
		node.getNext().setPrev(node.getPrev());
		node.getPrev().setNext(node.getNext());
		e output = node.getData();
		size--;
		node.setData(null);
		node.setNext(null);
		node.setPrev(null);
		print();
		return output;
	}
	
	public void print() {
		Node<e> curr = head.getNext();
		e[] arr = (e[]) new Object[size];
		
		for (int k = 0; k < size; k++) {
			arr[k] = curr.getData();
			curr = curr.getNext();
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	
}
