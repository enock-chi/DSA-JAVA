package dsa310;
import java.util.*;

public class CircLink<T>{
//================================================
	private static class Node<T>{
		private T data;
		private Node<T> next;
		public Node(T el, Node<T> n) {
			data = el;
			next = n;
		}
		
		public T getData() { return data;}
		
		public void setNext(Node<T> n){ next = n;}
		
		public Node<T> getNext(){return next;}
	}
//================================================
	private Node<T> tail;
	private int size = 0;
	
	public int size() {
		if (tail == null || tail.getNext() == null) {
	        return 0;
	    } else {
	        Node<T> curr = tail.getNext();
	        int count = 1;
	        while (curr != tail) {
	            curr = curr.getNext();
	            count++;
	        }
	        return count;
	    }
	}
	
	public boolean isEmpty() { return (size() == 0 ) ? true : false;}
	
	public void addFirst(T el) {
		Node<T> newest = new Node<>(el,null);
		if ( isEmpty()) {
			tail = newest;
			tail.setNext(tail);
		} else {
			newest.setNext(tail.getNext());
			tail.setNext(newest) ;
		}
		size++;
	}
	
	public void addLast(T el) {
		Node<T> newest = new Node<>(el,tail);
		tail.setNext(newest);
		tail = newest;
	}
	
	public T first() { return tail.getNext().getData();}
	
	public T last() { return tail.getData();}
	
	public T removeFirst() {
		Node<T> temp = tail.getNext();
		tail.setNext(tail.getNext().getNext());
		temp.setNext(null);
		return temp.getData();
	}
	
	public void output() {
		int count = size();
		int[] arr = new int[size()];
		Node<T> curr = tail;
		for ( int k = 0; k < count ; k++) {
			arr[k] = (int)curr.getData();
			curr = curr.getNext();
		}
		System.out.println(Arrays.toString(arr));
		
	}

}
