package dsa761;

import java.util.Arrays;

public class LinkedPositionalList<E> implements PositionalList<E> {
//=================================================== Nested Node Class ===================================================
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
			//if ( next == null) throw new IllegalStateException("Position not available");
			return data;
		}
		
		public Node<E> getPrev(){ return prev; }
		
		public Node<E> getNext(){ return next; }
		
		public void setPrev( Node<E> prev ) { this.prev = prev; }
		
		public void setNext( Node<E> next ) { this.next = next; }
		
		public void setData( E data ) { this.data = data; }
	}
//================================================= End Nested Node Class =================================================
	private Node<E> head = new Node<>(null,null,null);
	private Node<E> tail = new Node<>(null,head,null);
	private int size = 0;
	
	private Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Position not valid");
		Node<E> node = (Node<E>) p;
		if (node.getNext() == null) throw new IllegalArgumentException("Position not in set");
		return node;
	}
	
	private Position<E> position(Node<E> n){
		if (n == head || n == tail) return null;
		return n;
	}
	
	private Position<E> addBetween(E data, Node<E> prev, Node<E> next) throws IllegalArgumentException{
		Node<E> newest = new Node(data,prev,next);
		prev.setNext(newest);
		next.setPrev(newest);
		size++;
		return newest;
	}
	
	public LinkedPositionalList() {
		head.setNext(tail);
	}
	
	public int size() { return size; }
	
	public boolean isEmpty() { return (size == 0); }
	
	public Position<E> first() { return position(head.getNext()); }
	
	public Position<E> last() { return position(tail.getPrev()); }
	
	public Position<E> addFirst(E data) { return addBetween(data,head,head.getNext()); }
	
	public Position<E> addLast( E data ) { return addBetween(data, tail.getPrev(), tail); }
	
	public Position<E> before(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return position(node.getPrev());
	}
	
	public Position<E> after(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return position(node.getNext());
	}
	
	public Position<E> addBefore(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(data,node.getPrev(),node);
	}
	
	public Position<E> addAfter(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(data,node,node.getNext());
	}
	
	public E set( Position<E> p, E data ) throws IllegalArgumentException{
		Node<E> node = validate(p);
		E removedData = node.getData();
		node.setData(data);
		return removedData;
	}
	
	public E remove(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		E removedData = node.getData();
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
		node.setData(null);
		node.setNext(null);
		node.setPrev(null);
		node = null;
		size--;
		return removedData;
	}
	
	public void print() {
		E[] outputCluster = (E[]) new Object[size];
		Node<E> cursor = (Node<E>) first();
		for (int k = 0; k < size ; k++) {
			outputCluster[k] = cursor.getData();
			cursor = cursor.getNext();
		}
		System.out.println(Arrays.toString(outputCluster));
	}
	

}
