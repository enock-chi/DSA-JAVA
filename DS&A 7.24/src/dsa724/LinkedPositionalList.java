package dsa724;
import java.util.*;

public class LinkedPositionalList<e> implements PositionalList<e> {
//==================================================================
	private static class Node<e> implements Position<e>{
		e data;
		Node<e> prev;
		Node<e> next;
		
		public Node(e data, Node<e> prev, Node<e> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public e getData() throws IllegalStateException{
			if (next == null) throw new IllegalStateException("Position not available");
			return data;
		}
		
		public Node<e> getPrev(){ return prev;}
		
		public Node<e> getNext(){ return next;}
		
		public void setPrev(Node<e> prev) { this.prev = prev;}
		
		public void setNext(Node<e> next) { this.next = next;}
		
		public void setData(e data) { this.data = data;}
	}
//==================================================================
	private Node<e> head;
	private Node<e> tail;
	private int size = 0;
	
	private Node<e> validate(Position<e> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Position not valid"); 
		Node<e> node = (Node<e>)p;
		if (node.getNext() == null) throw new IllegalArgumentException("Element is not in set");
		return node;
	}
	
	private Position<e> position(Node<e> n) {
		if ( n == tail || n == head ) return null;
		return n;
	}
	
	private Position<e> addBetween(e data, Node<e> prev, Node<e> next){
		Node<e> node = new Node<>(data,prev,next);
		prev.setNext(node);
		next.setPrev(node);
		size++;
		return node;
	}
	
	public LinkedPositionalList() {
		head = new Node<>(null,null,null);
		tail = new Node<>(null,head,null);
		head.setNext(tail);
	}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public Position<e> first(){ return position(head.getNext()); }
	
	public Position<e> last(){ return position(tail.getPrev()); }
	
	public Position<e> before(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return node.getPrev();
	}
	
	public Position<e> after(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return node.getNext();
	}
	
	public Position<e> addFirst(e data){ return addBetween(data,head,head.getNext());}
	
	public Position<e> addLast(e data){ return addBetween(data,tail.getPrev(),tail);}
	
	public Position<e> addBefore(Position<e> p, e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return addBetween(data, node.getPrev(),node);
	}
	
	public Position<e> addAfter(Position<e> p, e data) throws IllegalArgumentException{
		Node<e> node = validate(p);
		return addBetween(data,node,node.getNext());
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
		node.getNext().setNext(node.getPrev());
		return removed;
	}
	
	@Override
	public String toString() {
		Node<e> node = head.getNext();
		StringBuilder sb = new StringBuilder("[");
		for ( int k = 0; k < size; k++) {
			sb.append(node.getData());
			if (size - 1 != k) sb.append(",");
			node = node.getNext();
		}
		sb.append("]");
		return sb.toString();
	}
//=======================================Nested PositionIterator Class==================================
	private class PositionIterator implements Iterator<Position<e>>{
		private Position<e> cursor =  first();
		private Position<e> recent = null;
	
		public boolean hasNext() { return (cursor != null);}
		
		public Position<e> next() throws NoSuchElementException{
			if (cursor == null) throw new NoSuchElementException("List is empty");
			recent = cursor;
			cursor = after(cursor);
			return recent;
		}
		
		public void remove() throws IllegalArgumentException {
			if ( recent == null) throw new IllegalArgumentException("List is empty, nothing to remove");
			LinkedPositionalList.this.remove(recent);
			recent = null;
		}
	}
//======================================Nested PositionIterable Class===================================
	private class PositionIterable implements Iterable<Position<e>>{
		public Iterator<Position<e>> iterator(){ return new PositionIterator();}
	}
//======================================================================================================
	public Iterable<Position<e>> positions(){ return new PositionIterable();}
//======================================Nested ElementIterator Class====================================
	private class ElementIterator implements Iterator<e>{
		Iterator<Position<e>> posIterator = new PositionIterator();
		public boolean hasNext() { return posIterator.hasNext();}
		public e next() { return posIterator.next().getData();}
		public void remove() { posIterator.remove();}
	}
//======================================================================================================
	
	public Iterator<e> iterator(){ return new ElementIterator();}
}



















