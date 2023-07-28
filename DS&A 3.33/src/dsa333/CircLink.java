package dsa333;
import java.util.*;

public class CircLink<d> {
//===================================================
	private static class Node<d>{
		private d data;
		private Node<d> next;
		public Node(d el, Node<d> n) {
			data = el;
			next = n;
		}
		
		public d getData() { return data;}
		
		public void setNext(Node<d> n) { next = n;}
		
		public Node<d> getNext(){ return next;}
	}
//===================================================
	
	private Node<d> head = null;
	private int size = 0;
	
	public CircLink() {	}
	
	public boolean isEmpty() { return ( size == 0) ? true:false;}
	
	public void add( d el) {
		if (isEmpty()) {
			head = new Node<>(el,null);
			head.setNext(head);
		} else {
			Node<d> newest = new Node<>(el,head.getNext());
			head.setNext(newest);
		}
		size++;
	}
	
	public void remove() {
		Node<d> temp = head.getNext();
		head.setNext(head.getNext().getNext());
		temp.setNext(null);
	}
	
	public void output() {
		Node<d> curr = head;
		int[] arr = new int[size];
		
		for ( int k = 0; k < size; k++) {
			arr[k] = (int)curr.getData();
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("================================");
		System.out.println(size);
	}

}
