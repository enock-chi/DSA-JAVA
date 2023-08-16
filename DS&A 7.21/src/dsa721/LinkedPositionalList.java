package dsa721;
import java.util.*;
import java.lang.Iterable;

public class LinkedPositionalList<e> implements PositionalList<e>{
//======================================================================================
	private static class Node<e> implements Position<e>{
		private e data;
		private Node<e> prev;
		private Node<e> next;
		
		public Node(e data, Node<e> prev, Node<e> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public e getData() { 
			if ( next == null ) throw new IllegalStateException("Position not valid");
			return data;
		}
		
		public Node<e> getPrev(){ return prev;}
		
		public Node<e> getNext(){ return next;}
		
		public void setPrev(Node<e> prev) { this.prev = prev;}
		
		public void setNext(Node<e> next) { this.next = next;}
		
		public void setData(e data) { this.data = data;}
		
	}
//========================================================================================
	private Node<e> head;
	private Node<e> tail;
	private int size = 0;
	
	private Node<e> validate(Position<e> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid Position");
		Node<e> node = (Node<e>) p;
		if (node.getNext() == null) throw new IllegalArgumentException("Position is not available");
		return node;
	}
	
	private Position<e> position(Node<e> n){
		if (n == head || n == tail) return null;
		return n;
	}
	
	private Position<e> addBetween(e data,Node<e> prev, Node<e> next){
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
	
	public e get(Position<e> p) {
		Node<e> node = validate(p);
		return node.getData();
	}
	
	public Position<e> addFirst(e data){ ;
		return addBetween(data,head,head.getNext());
	}
	
	public Position<e> addLast( e data){
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
		e removed = node.getData();
		node.setData(data);
		return removed;
		
	}
	
	public e remove(Position<e> p) throws IllegalArgumentException{
		Node<e> node = validate(p);
		e removed = node.getData();
		node.getNext().setPrev(node.getPrev());
		node.getPrev().setNext(node.getNext());
		node.setNext(null);
		node.setPrev(null);
		node.setData(null);
		size--;
		return removed;
	}
	
	public void print() {
		Node<e> curr = (Node<e>) first();
		e[] arr = (e[]) new Object[size];
		for (int k = 0; k < size; k++) {
			arr[k] = curr.getData();
			curr = curr.getNext();
		}
		System.out.println(Arrays.toString(arr));
	}
//========================nested PositionIterator class=======================
	private class PositionIterator implements Iterator<Position<e>>{
		private Position<e> cursor = first();
		private Position<e> recent = null;
		
		public boolean hasNext() { return (cursor != null);}
		
		public Position<e> next() throws NoSuchElementException{
			if ( cursor == null ) throw new NoSuchElementException("End of set reached");
			recent = cursor;
			cursor = after(cursor);
			return recent;
		}
		
		public void remove() throws IllegalArgumentException{
			if ( recent == null ) throw new IllegalArgumentException("Set is empty");
			LinkedPositionalList.this.remove(recent);
			recent = null;
		}
	}
//=========================nested PositionIterable class=======================
	private class PositionIterable implements Iterable<Position<e>>{
		public Iterator<Position<e>> iterator(){ return new PositionIterator();}

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		public Position<e> next() {
			// TODO Auto-generated method stub
			return null;
		}
	}
//=============================================================================
	public Iterable<Position<e>> positions(){
		return new PositionIterable();
	}
//==========================nested ElementIterator class=======================
	private class ElementIterator implements Iterator<e>{
		Iterator<Position<e>> posIterator = new PositionIterator();
		public boolean hasNext() { return posIterator.hasNext();}
		public e next() { return posIterator.next().getData();}
		public void remove() {posIterator.remove();}
	}
//=============================================================================
	@Override
	public Iterator<e> iterator(){ return new ElementIterator();}
	
}
