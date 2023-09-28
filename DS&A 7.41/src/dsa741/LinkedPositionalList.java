package dsa741;
import java.util.*;

public class LinkedPositionalList<e> implements PositionalList<e>, Cloneable {
//===================================Nested Node Class===================================
	private static class Node<e> implements Position<e>{
		private e data;
		private Node<e> prev;
		private Node<e> next;
		
		public Node(e data, Node<e> prev, Node<e> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public e getData() throws IllegalStateException{
			if ( next == null) throw new IllegalStateException("Position not valid");
			return data;
		}
		
		public Node<e> getPrev(){ return prev;}
		
		public Node<e> getNext(){ return next;}
		
		public void setPrev(Node<e> prev) { this.prev = prev;}
		
		public void setNext(Node<e> next) { this.next = next;}
		
		public void setData(e data) { this.data = data;}
	}
//=================================End Nested Node Class=================================
	private Node<e> head = new Node<>(null,null,null);
	private Node<e> tail = new Node<>(null,head,null);
	int size = 0;
	
	private Node<e> validate(Position<e> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid Position");
		Node<e> node = (Node<e>) p;
		if ( node.getNext() == null) throw new IllegalArgumentException("Position not available");
		return node;
	}
	
	private Position<e> position(Node<e> n){
		if ( n == head || n == tail) return null;
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
		head.setNext(tail);
	}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public Position<e> first(){ return position(head.getNext());}
	
	public Position<e> last(){ return position(tail.getPrev());}
	
	public Position<e> addFirst(e data) { return addBetween(data,head,head.getNext());}
	
	public Position<e> addLast(e data){ return addBetween(data,tail.getPrev(),tail);}
	
	public Position<e> before(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return position(node.getPrev());
	}
	
	public Position<e> after(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return position(node.getNext());
	}
	
	public Position<e> addBefore(Position<e> p, e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return addBetween(data, node.getPrev(),node);
	}
	
	public Position<e> addAfter(Position<e> p, e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return addBetween(data, node, node.getNext());
	}
	
	public e set(Position<e> p, e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		e removed = node.getData();
		node.setData(data);
		return removed;
	}
	
	public e remove(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		e removed = node.getData();
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
		node.setData(null);
		node.setNext(null);
		node.setPrev(null);
		node = null;
		size--;
		return removed;
	}
	
	public void print() {
		e[] tempStore = (e[]) new Object[size];
		Node<e> cursor = (Node<e>) first();
		
		for ( int k = 0; k < size ; k++) {
			tempStore[k] = cursor.getData();
			cursor = cursor.getNext();
		}
		System.out.println(Arrays.toString(tempStore));
	}
	
	@Override
	public LinkedPositionalList<e> clone() throws CloneNotSupportedException{
		LinkedPositionalList<e> other = new LinkedPositionalList<>();
		if (size > 0) {
			Node<e> cursor = (Node<e>) first();
			for (int k = 0; k < size; k++) {
				other.addLast(cursor.getData());
				cursor = cursor.getNext();
			}
		}
		return other;
	}

}
