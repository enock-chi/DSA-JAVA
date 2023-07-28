package dsa37;

import java.util.Arrays;

public class CircList<T> {
//=======================================
	private static class Node<T>{
		T data;
		Node<T> next;
		Node<T> prev;
		public Node(T data, Node<T> next, Node<T> prev){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		public T getData() { return data;}
		
		public Node<T> getNext(){ return next;}
		
		public Node<T> getPrev(){ return prev;}
		
		public void setNext(Node<T> next) { this.next = next;}
		
		public void setPrev(Node<T> prev) {this.prev = prev;}
	}
//=======================================
	private Node<T> head = new Node<>(null,null,null);
	private Node<T> tail = new Node<>(null, null, head);
	private int size = 0;
	
	public CircList() { head.setNext(tail);}
	
	public boolean isEmpty() {
		if ( size == 0 && head == null && tail == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public int size() {return size;}
	
	public T first(){ return (isEmpty()) ?  null :  head.getNext().getData();}
	
	public T last(){ return (isEmpty()) ? null : tail.getPrev().getData();}
	
	public void addFirst(T el) {
		addBetween(el,head.getNext(),head);
	}
	
	public void addLast(T el) {
		addBetween(el,tail,tail.getPrev());
	}
	
	public void addBetween(T el, Node<T> next, Node<T> prev) {
		Node<T> newest = new Node<>(el,next,prev);
		prev.setNext(newest);
        next.setPrev(newest);
        size++;
	}
	
	public T removeFirst() {
		return (isEmpty()) ? null : remove(head.getNext());
	}
	
	public T  removeLast() {
		return (isEmpty()) ? null : remove(tail.getPrev());
	}
	
	public T remove(Node<T> el) {
		el.getNext().setPrev(el.getPrev());
        el.getPrev().setNext(el.getNext());
        size--;
        return el.getData();
	}
	
	public void output() {
		int[] output = new int[size];
		Node<T> curr = head.getNext();
		for ( int k = 0; k < size; k++) {
			output[k] = (int)curr.getData();
			curr = curr.getNext();
		}
		System.out.println(Arrays.toString(output));
	}
	

}
