package dsa629;

import java.util.Arrays;

public class LinkedList<e> {
//===========================================
	public static class Node<e>{
		private e data;
		private Node<e> next;
		
		public Node( e data, Node<e> next) {
			this.data = data;
			this.next = next;
		}
		
		public e getData() { return data;}
		
		public Node<e> getNext(){ return next;}
		
		public void setNext(Node<e> next) { this.next = next;}
	}
//===========================================
	private Node<e> head = null;
	private Node<e> tail = null;
	private int size = 0;
	
	public LinkedList() {}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public e top() {
		return head.getData();
	}
	
	public void push(e data) {
		Node<e> newest = new Node<>(data,null);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	
	public e pop() {
		Node<e> node = head;
		if (isEmpty()) return null;
		head = node.getNext();
		node.setNext(null);
		size--;
		return node.getData();
	}
	
	public void print() {
		Node<e> curr = head;
		e[] arr = (e[]) new Object[size];
		for (int k = 0; k < size; k++) {
			arr[k] = curr.getData();
			curr = curr.getNext();
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public void concatenate(LinkedQueue<e> q) {
		int size = q.size();
		for (int k = 0; k < size; k++) {
			push(q.dequeue());
		}
	}

}

/*
 * A method called head() and tail() 
 * will be needed to complete this to run in O(n) time
 */
