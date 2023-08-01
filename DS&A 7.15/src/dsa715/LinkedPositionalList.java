package dsa715;
import java.util.*;

public class LinkedPositionalList<e> implements PositionalList<e> {
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
	private Node<e> tail ;
	private Node<e> head ;
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
	
	private Position<e> addBetween(e data, Node<e> prev , Node<e> next){
		Node<e> newest = new Node<>(data,prev,next);
		prev.setNext(newest);
		next.setPrev(newest);
		size++;
		return newest;
	}
	
	public LinkedPositionalList() {
		head = new Node<>(null,null, null);
		tail = new Node<>(null,head, null);
		head.setNext(tail);
	}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public Position<e> first(){ return head.getNext();}
	
	public Position<e> last(){ return tail.getPrev();}
	
	public Position<e> addFirst(e data){
		return addBetween(data,head,head.getNext());
	}
	
	public Position<e> addLast(e data){
		return addBetween(data,tail.getPrev(),tail);
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
		return addBetween(data,node.getPrev(),node);
	}
	
	public Position<e> addAfter(Position<e> p, e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return addBetween(data,node,node.getNext());
	}
	
	public e set(Position<e> p, e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		e swapped = node.getData();
		node.setData(data);
		return swapped;
	}
	
	public e remove(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		e removed = node.getData();
		node.getNext().setPrev(node.getPrev());
		node.getPrev().setNext(node.getNext());
		node.setData(null);
		node.setNext(null);
		node.setPrev(null);
		size--;
		return removed;
	}
	
	public void print() {
		Node<e> curr = (Node<e>) first();
		e[] arr = (e[]) new Object[size];
		for (int k = 0; k < size ; k++) {
			arr[k] = curr.getData();
			curr = curr.getNext();
		}
		System.out.println(Arrays.toString(arr));
	}
	
}
