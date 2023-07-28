package dsa38;

import java.util.Arrays;

public class CircList<T> {
//======================================================
	private static class Node<T>{
		private T data;
		private Node<T> prev;
		private Node<T> next;
		public Node(T data, Node<T> p, Node<T> n) {
			this.data = data;
			prev = p;
			next = n;
		}
		
		public T getData() { return data;}
		
		public Node<T> getPrev(){ return prev;}
		
		public Node<T> getNext(){ return next;}
		
		public void setPrev(Node<T> p) { prev = p;}
		
		public void setNext(Node<T> n) { next = n;}
	}
//======================================================
	
	private Node<T> head = new Node<>(null, null , null);
	
	private Node<T> tail = new Node<>(null, head, null);
	
	private int size = 0 ; 
	
	public CircList() {
		head.setNext(tail);
	}
	
	public T remove(Node<T> el){
		el.setPrev(el.getNext());
		el.setNext(el.getPrev());
		size--;
		return el.getData();
	}
	
	public void addBetween(T el, Node<T> p, Node<T> n) {
		Node<T> newest = new Node<>(el,p,n);
		p.setNext(newest);
		n.setPrev(newest);
		size++;
	}
	
	public boolean isEmpty() { return ( size == 0 ) ? true : false;}
	
	public int size() { return size;}
	
	public T first(){ return (isEmpty())? head.getNext().getData() : null;}
	
	public T last(){ return (isEmpty())? tail.getPrev().getData() : null;}
	
	public void addFirst(T el) {
		addBetween(el,head, head.getNext());
	}
	
	public void addLast(T el) {
		addBetween(el, tail.getPrev(), tail);
	}
	
	public T removeFirst() { return (isEmpty()) ? remove(head.getNext()) : null;}
	
	public T removeLast() { return (isEmpty()) ? remove(tail.getPrev()) : null;}
	
	public void output() {
		Node<T> curr = head.getNext();
		int[] arr = new int[size];
		for ( int k = 0; k < size; k++) {
			arr[k] = (curr.getData() == null) ? 0:(int)curr.getData();
			curr= curr.getNext();
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(size);
	}
	
	public void findMid() {
		Node<T> slowPtr = head.getNext(); 
	    Node<T> fastPtr = head.getNext(); 
	    int count = 0;

	    while (fastPtr != tail.getPrev() && fastPtr.getNext() != tail.getPrev()) {
	        slowPtr = slowPtr.getNext();
	        fastPtr = fastPtr.getNext().getNext();
	        count++;
	    }
		System.out.println((count / 2 == 0) ? slowPtr.getPrev().getData():slowPtr.getData());
	}
	
}
