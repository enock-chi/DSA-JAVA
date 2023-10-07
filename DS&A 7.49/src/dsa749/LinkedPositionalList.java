package dsa749;
import java.util.*;

public class LinkedPositionalList<E> implements PositionalList<E> {
//============================================Nested Node Class============================================
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
//==========================================End Nested Node Class==========================================
	private Node<E> head = new Node<>(null,null,null);
	private Node<E> tail = new Node<>(null,head,null);
	private int size = 0;
	
	private Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Position Not Valid");
		Node<E> node = (Node<E>) p;
		if (node.getNext() == null) throw new IllegalArgumentException("Position not available");
		return node;
	}
	
	private Position<E> position(Node<E> n){
		if ( n == head || n == tail) return null;
		return n;
	}
	
	private Position<E> addBetween(E data, Node<E> prev, Node<E> next){
		Node<E> newest = new Node<>(data,prev,next);
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
	
	public Position<E> first(){ return position(head.getNext());}
	
	public Position<E> last(){ return position(tail.getPrev());}
	
	public Position<E> addFirst(E data) { return addBetween(data,head,head.getNext());}
	
	public Position<E> addLast(E data) { return addBetween(data,tail.getPrev(),tail);}
	
	public Position<E> before(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return position(node.getPrev());
	}
	
	public Position<E> after(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return position(node.getPrev());
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
		node.getNext().setPrev(node.getPrev());
		node.setData(null);
		node.setNext(null);
		node.setData(null);
		node = null;
		size--;
		return removed;
	}
	
//============================================Nested ListIterator Class============================================
	private class LinkedIterator implements ListIterator<Position<E>>{
		private Position<E> cursor =  first();
		private Position<E> recent = null;
		@Override
		public boolean hasNext() { return (cursor != null);}
		@Override
		public Position<E> next() throws NoSuchElementException{
			if (cursor == null) throw new NoSuchElementException("List Empty!");
			recent = cursor;
			cursor = after(cursor);
			return recent;
		}
		@Override
		public boolean hasPrevious() throws NoSuchElementException{
			if ( recent == null) throw new NoSuchElementException("");
			return (before(recent) != null);
		}
		@Override
		public Position<E> previous() {
			if (!hasPrevious()) throw new NoSuchElementException("");
			cursor = recent;
			recent = before(recent);
			return recent;
		}
		@Override
		public int nextIndex() {
			Position<E> current = first();
			for (int k = 0; k < size; k++) {
				if ( current == cursor ) {
					return k;
				}
			}
			return -1;
		}
		@Override
		public int previousIndex() {
			Position<E> current = last();
			for ( int k = size - 1; k > 0; k--) {
				if (current == recent) {
					return k - 1;
				}
			}
			return -1;
		}
		@Override
		public void remove() throws IllegalStateException {
			if (isEmpty()) throw new IllegalStateException("List Empty");
			LinkedPositionalList.this.remove(recent);
			recent = before(cursor);
		}
		@Override
		public void set(Position<E> p) {
			cursor = p;
			
		}
		@Override
		public void add(Position<E> p) {
			Node<E> node = validate(p);
			addLast(node.getData());
		}

		
	}
	
	private 
//==========================================End Nested ListIterator Class==========================================

}
