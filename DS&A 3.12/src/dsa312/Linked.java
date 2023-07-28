package dsa312;
import java.util.*;

public class Linked<e> {
//======================================
	private static class Node<e>{
		private e data;
		private Node<e> next;
		public Node(e el, Node<e> n) {
			data = el;
			next = n;
		}
		
		public e getData() { return data;}
		
		public Node<e> getNext() {return next;}
		
		public void setNext(Node<e> n) { next = n;}
	}
//=====================================
	
	private Node<e> head;
	private Node<e> tail;
	private int size = 0;
	
	
	public Linked() {}
	
	public boolean isEmpty() { return ( size == 0 && head == null && tail == null) ? true : false;}
	
	public void addFirst(e el) {
		head = new Node<>(el, head);
		if (isEmpty()) {
			tail = head;
		}
		size++;
	}
	
	public void addLast(e el) {
		Node<e> newest = new Node<>(el,null);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	
	public void rotate() {
		Node<e> temp = head;
		head = head.getNext();
		tail.setNext(temp);
		tail = temp;
		
	}
	
	public void output() {
		Node<e> curr = head;
		int[] arr = new int[size];
		for ( int k = 0; k < size; k++) {
			arr[k] = (int)curr.getData();
			curr = curr.getNext();
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("============================================");
		System.out.println("");
	}

}
