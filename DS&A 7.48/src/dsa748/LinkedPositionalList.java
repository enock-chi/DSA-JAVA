package dsa748;
import java.util.*;

public class LinkedPositionalList<E> implements PositionalList<E>{
//================================================Nested Node Class================================================
	private static class Node<E> implements Position<E>{
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E data, Node<E> prev, Node<E> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public E getData() throws IllegalStateException {
			if (next == null) throw new IllegalStateException("Invalid Position");
			return data;
		}
		
		public Node<E> getPrev(){ return prev;}
		
		public Node<E> getNext(){ return next;}
		
		public void setData(E data) { this.data = data;}
		
		public void setPrev(Node<E> prev) { this.prev = prev;}
		
		public void setNext(Node<E> next) { this.next = next;}
		
	}
//==============================================End Nested Node Class==============================================
	private Node<E> head = new Node<>(null,null,null);
	private int size = 0;
	
	private Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid Position");
		Node<E> node = (Node<E>) p;
	    if (node.getNext() == null) throw new IllegalArgumentException("Position not availabe");
	    return node;
	}
	
	private Position<E> addBetween(E data, Node<E> prev, Node<E> next){
		Node<E> newest = new Node<>(data,prev,next);
		if ( size == 0) {
			head = newest;
			newest.setNext(head);
			newest.setPrev(head);
		} else {
			prev.setNext(newest);
		    next.setPrev(newest);
		}
		size++;
		return newest;
	}
	
	public LinkedPositionalList() {	}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public Position<E> first(){ return head;}
	
	public Position<E> last(){ return head.getPrev();}
	
	public Position<E> addFirst(E data) { return addBetween(data,head,head.getNext());}
	
	public Position<E> addLast(E data) { return addBetween(data,head.getPrev(),head);}
	
	public Position<E> before(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getPrev();
	}
	
	public Position<E> after(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getNext();
	}
	
	public Position<E> addBefore(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(data,node.getPrev(),node);
	}
	
	public Position<E> addAfter(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(data,node,node.getNext());
	}
	
	public E set(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> node = validate(p);
		E removed = node.getData();
		node.setData(data);
		return removed;
	}
	
	public E remove(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		E removed = node.getData();
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.prev);
		node.setData(null);
		node.setPrev(null);
		node.setNext(null);
		size--;
		return removed;
	}
	
	public void print() {
		E[] storage = (E[]) new Object[size];
		Node<E> cursor = (Node<E>) first();
		for (int k = 0; k < size ; k++) {
			storage[k] = cursor.getData();
			cursor = cursor.getNext();
		}
		System.out.println(Arrays.toString(storage));
	}
	

}
