package dsa36;

import java.util.Arrays;

public class LinkedList<T> {
//================================================
	private static class Node<T>{
		private T data;
		private Node<T> next;
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		public T getData() { return data;}
		
		public Node<T> getNext(){ return next;}
		
		public void setNext(Node<T> n) { next = n;}
	}
//=================================================
	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;
	
	public LinkedList() { };
	
	public int getSize() { return size;}
	
	public boolean isEmpty() {
		boolean ans ;
		if ((head == null) && (tail==null) && (size == 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	public T first() {
		if (isEmpty()) {return null;}
		return head.getData();
	}
	
	public T last() {
		if (isEmpty()) {return null;}
		return tail.getData();
	}
	
	public void insert(T data) {
		head = new Node<>(data,head);
		if (size == 0) { tail = head;}
		size++;
	}
	
	public void append(T data) {
		Node<T> newest = new Node<>(data,null);
		if ( isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail= newest;
		size++;
	}
	
	public T removeFirst() {
		if (isEmpty()) { return null;}
		T ans = head.getData();
		head = head.getNext();
		size--;
		if (size == 0) {
			head = null;
			tail = null;
		}
		return ans;
	}
	
	public T finder() {
		Node<T> curr = head;
		for ( int k = 0; k < (size - 2); k++ ) {
			curr = curr.getNext();
		}
		return curr.getData();
	}
	
	public void display() {
		int[] arr = new int[size];
		Node<T> curr = head;
		for (int k = 0; k < size; k++) {
			arr[k] = (int)curr.getData();
			curr = curr.getNext();
		}
		System.out.println(Arrays.toString(arr));
	}

}
