package dsa721;
import java.util.*;

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
	private ArrayList<Position<e>> list = new ArrayList<>();
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
	
	public e get(int k) {
		Node<e> node = validate(list.get(k));
		return node.getData();
	}
	
	public Position<e> addFirst(e data){ 
		list.add(0,addBetween(data,head,head.getNext()));
		return list.get(0);
	}
	
	public Position<e> addLast( e data){
		list.add(addBetween(data,tail.getPrev(),tail));
		return list.get(size - 1);
	}
	
	public Position<e> before(int i) throws IllegalArgumentException{
		Node<e> node = validate(list.get(i));
		return node.getPrev();
	}
	 
	public Position<e> after(int i) throws IllegalArgumentException{
		Node<e> node = validate(list.get(i));
		return node.getNext();
	}
	
	public Position<e> addBefore(int i, e data) throws IllegalArgumentException{
		Node<e> node = validate(list.get(i));
		return addBetween(data,node.getPrev(),node);
	}
	
	public Position<e> addAfter(int i, e data) throws IllegalArgumentException{
		Node<e> node = validate(list.get(i));
		return addBetween(data,node,node.getNext());
	}
	
	public e set(int i, e data) throws IllegalArgumentException{
		Node<e> node = validate(list.get(i));
		e removed = node.getData();
		node.setData(data);
		return removed;
		
	}
	
	public e remove(int i) throws IllegalArgumentException{
		Node<e> node = validate(list.remove(i));
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
		e[] arr = (e[]) new Object[size];
		for (int k = 0; k < size; k++) {
			Node<e> node = validate(list.get(k));
			arr[k] = node.getData();
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public int index(Position<e> p) throws IllegalArgumentException{
		return list.indexOf(p);
	}
	
//==============================================================================================
	private class PositionIterator implements Iterator<Position<e>>{
		private Position<e> cursor = first();
		private Position<e> recent = null;
		
		public boolean hasNext() { return (cursor != null);}
		
		public Position<e> next() throws NoSuchElementException{
			if (cursor == null) throw new NoSuchElementException("Next is invalid");
			recent = cursor;
			cursor = after(list.indexOf(cursor));
			return recent;
		}
		
		public void remove() throws IllegalArgumentException{
			if ( recent == null) throw new IllegalArgumentException("Set is empty");
			LinkedPositionalList.this.remove(list.indexOf(recent));
			recent = null;
		}
//===============================================================================================
		
		private class ElementIterator implements Iterable<Position<e>>{
			Iterator<Position<e>> posIterator = new PositionIterator();
			public boolean hasNext() { return posIterator.hasNext();}
			public e next() { return posIterator.next().getData();}
			public void remove() { posIterator.remove();}
		}
//===============================================================================================
		
		private class PositionIterable implements Iterable<Position<e>>{
			@Override
			public Iterator<Position<e>> iterator(){ return new PositionIterator();}
		}
		
		
		public Iterable<Position<e>> positions(){ return new PositionIterable();}
		
//===============================================================================================
		
	
		public Iterator<e> iterator(){ return new ElementIterator();}
		
	}
}
