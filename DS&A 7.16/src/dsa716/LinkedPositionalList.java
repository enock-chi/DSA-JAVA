package dsa716;
import java.util.*;

public class LinkedPositionalList<e> implements PositionalList<e> {
//==================================================================================================
	private static class Node<e> implements Position<e>{
		private e data;
		private Node<e> prev;
		private Node<e> next;
		
		public Node(e data, Node<e> prev, Node<e> next ) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public e getData() throws IllegalStateException {
			//if (next == null) throw new IllegalStateException("Position not valid");
			return data;
		}
		
		public Node<e> getNext(){ return next;}
		
		public Node<e> getPrev(){ return prev;}
		
		public void setData(e data) { this.data = data;}
		
		public void setNext(Node<e> next) { this.next = next;}
		
		public void setPrev(Node<e> prev) { this.prev = prev;}
	}
//==================================================================================================
	private ArrayList<Position<e>> list = new ArrayList();
	private Node<e> head;
	private Node<e> tail;
	int size = 0;
	
	private Node<e> validate(Position<e> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid position");
		Node<e> node = (Node<e>) p;
		if (node == null) throw new IllegalArgumentException("Position not in list");
		return node;
	}
	
	private Position<e> addBetween(e data, Node<e> prev, Node<e> next){
		Node<e> newest = new Node<>(data,prev,next);
		prev.setNext(newest);
		next.setPrev(newest);
		size++;
		return newest;
	}
	
	private Position<e> position(Node<e> node){
		if ( node == head || node == tail ) return null;
		return node;
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
	
	public Position<e> addFirst(e data){
		list.add(0,addBetween(data,head,head.getNext()));
		return list.get(0);
	}
	
	public Position<e> addLast(e data){
		list.add(addBetween(data, tail.getPrev(),tail));
		return list.get(size-1);
	}
	
	public e before(int i) throws IllegalArgumentException{
		Node<e> node = validate(list.get(i));
		return node.getPrev().getData();
	}
	
	public e after(int i) throws IllegalArgumentException{
		Node<e> node = validate(list.get(i));
		return node.getNext().getData();
	}
	
	public e get(int i) throws IllegalArgumentException{
		Node<e> node = validate(list.get(i));
		return node.getData();
	}
	
	public Position<e> addAfter(int i, e data) throws IllegalArgumentException{
		Node<e> node = validate(list.get(i));
		list.add(i+1,addBetween(data,node,node.next));
		return list.get(i);
	}
	
	public Position<e> addBefore(int i, e data) throws IllegalArgumentException{
		Node<e> node = validate(list.get(i));
		list.add(i-1,addBetween(data,node.getPrev(),node));
		return list.get(i);
	}
	
	public e set(int i, e data) throws IllegalArgumentException{
		Node<e> node = validate(list.get(i));
		e output = node.getData();
		node.setData(output);
		return output;
	}
	
	public e remove(int i) throws IllegalArgumentException{
		Node<e> node = validate(list.get(i));
		node.getNext().setPrev(node.getPrev());
		node.getPrev().setNext(node.getNext());
		node.setData(null);
		node.setNext(null);
		node.setPrev(null);
		list.remove(i);
		size--;
		return node.getData();
	}
	
	public void print() {
		Node<e> curr = (Node<e>) first();
		e[] arr = (e[]) new Object[size];
		for ( int k = 0; k < size; k++) {
			arr[k] = curr.getData();
			curr = curr.getNext();
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public Iterator<e> alternateIterator(){
		return new AlternateIterator<>(this);
	}
	
	
}
