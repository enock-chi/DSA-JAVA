package dsa617;
import java.util.*;

public class LinkedList<E> {
//====================================================
	private static class Node<E>{
		private E data;
		private Node<E> next;
		
		public Node( E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
		
		public E getData() { return data;}
		public Node<E> getNext(){ return next;}
		public void setNext(Node<E> next) { this.next = next;}
	}
//=====================================================
	private Node<E> tail = new Node(null,null);
	private Node<E> head = new Node(null,tail);
	private int size = 0;
	
	public LinkedList() {}
	
	public int getSize() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public void addLast(E e) {
		Node<E> newest = new Node(e,null);
		if (isEmpty()) {
			newest.setNext(tail);
			head.setNext(newest);
		} else {
			newest.setNext(head.getNext());
			head.setNext(newest);
		}
		size++;
	}
	
	public E removeLast() {
		if (isEmpty()) { return null;}
		Node<E> last = head.getNext();
		head.setNext(last.getNext());
		size--;
		return last.getData();
	}
	
	public E first() {
		return head.getNext().getData();
	}
	
	public void output() {
		Object[] arr = new Object[size];
	    Node<E> item = head.getNext();
		for ( int k = 0; k < size ; k++) {
			arr[k] = item.getData();
			item = item.getNext();
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
