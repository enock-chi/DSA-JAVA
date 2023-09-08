package dsa734;
import java.util.*;

public class LinkedList<e> {
//===============================Nested Node=================================//
	private static class Node<e> {
		e data;
		Node<e> prev;
		Node<e> next;
		
		public Node(e data, Node<e> prev, Node<e> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public e getData() { return data;}
		
		public Node<e> getPrev(){ return prev;}
		
		public Node<e> getNext(){ return next;}
		
		public void setPrev(Node<e> prev) { this.prev = prev;}
		
		public void setNext(Node<e> next) { this.next = next;}
		
		public void setData(e data) { this.data = data;}
	}
//==================================End Node================================//
	private Node<e> head ;
	private Node<e> tail ;
	private int size = 0;
	
	public LinkedList() {
		head = new Node<>(null,null,null);
		tail = new Node<>(null,head,null);
		head.setNext(tail);
	}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public e first() { return head.getNext().getData();}
	
	public e last() { return tail.getPrev().getData();}
	
	public void addFirst(e data) {
		addBetween(data,head,head.getNext());
	}
	
	public void addLast( e data) {
		addBetween(data,tail.getPrev(),tail);
	}
	
	public e removeFirst() { return removeBetween(head,head.getNext(),head.getNext().getNext());}
	
	public e removeLast() { return removeBetween(tail.getPrev().getPrev(),tail.getPrev(),tail);}
	
	
	protected e removeBetween(Node<e> prev, Node<e> focus, Node<e> next) {
		e removed = focus.getData();
		prev.setNext(next);
		next.setPrev(prev);
		focus.setData(null);
		focus.setNext(null);
		focus.setPrev(null);
		size--;
		return removed;
	}
	
	protected void addBetween(e data, Node<e> prev, Node<e> next) {
		Node<e> newest = new Node<>(data,prev,next);
		prev.setNext(newest);
		next.setPrev(newest);
		size++;
	}
	
	public void print() {
		ArrayList list = new ArrayList<>();
		Node<e> cursor = head.getNext();
		for (int k = 0; k < size; k++) {
			list.add(cursor.getData());
			cursor = cursor.getNext();
		}
		System.out.println(list);
	}
	
}
