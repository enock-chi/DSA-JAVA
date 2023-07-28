package dsa39;
import java.util.*;

public class LinkedList<T> {
//=================================================
	private static class Node<T>{
		private T data;
		private Node<T> next;
		public Node( T el, Node<T> n) {
			this.data = el;
			next = n;
		}
		
		public T getData() { return data;}
		
		public Node<T> getNext(){ return next;}
		
		public void setNext(Node<T> n) { next = n;}
		
	}
//==================================================
	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;
	
	public LinkedList() {}
	
	public int size () { 
		int count = 1;
		Node<T> curr = head;
		while (curr != tail) {
			curr = curr.getNext();
			count++;
		}
		return count;
	}
	
	public boolean isEmpty() { return (size == 0) ? true : false;}
	
	public T first() { return (isEmpty()) ? null : head.getData();} 
	
	public T last() { return (isEmpty()) ?  null: tail.getData();}
	
	public void addFirst(T el) {
		Node<T> newest = new Node<>(el,head);
		head = newest;
		tail = ( isEmpty()) ? head : tail;
		size++;
	}
	
	public void addLast(T el) {
		Node<T> newest = new Node<>(el,null);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
			tail = newest;
		}
		size++;
	}
	
	public T removeFirst() {
		Node<T> el = head.getNext();
		head.setNext(el.getNext());
		el.setNext(null);
		size--;
		return el.getData();
	}
	
	public void output() {
		Node<T> curr = head;
		int[] arr = new int[size];
		for ( int k = 0; k < size ; k++) {
			arr[k] = (int)curr.getData();
			curr = curr.getNext();
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("==========================================");
		System.out.println("");
	}
}
