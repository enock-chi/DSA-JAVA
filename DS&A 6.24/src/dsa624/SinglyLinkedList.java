package dsa624;
import java.util.*;

public class SinglyLinkedList<e> {
//==============================================================
	private static class Node<e>{
		private e data;
		private Node<e> next;
		
		public Node(e data, Node<e> next) {
			this.data = data;
			this.next = next;
		}
		
		public e getData() { return data;}
		
		public Node<e> getNext(){ return next;}
		
		public void setNext(Node<e> next) { this.next = next;}
	}
//===============================================================
	private Node<e> tail = new Node<>(null,null);
	private Node<e> head = new Node<>(null,tail);
	private Node<e> curr;
	private int size = 0;
	
	public SinglyLinkedList() {}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public void push(e data) {
		Node<e> newest = new Node<>(data,null);
		if (isEmpty()) {
		     newest.setNext(tail);
		     head.setNext(newest);
		     curr = head.getNext();
		} else {
			newest.setNext(head.getNext());	
			head.setNext(newest);
			curr = head.getNext();
		}
		size++;
	}
	
	public e pop() {
		Node<e> deleted = head.getNext();
		if (isEmpty()) {
			return null;
		} else {
			head.setNext(deleted.getNext());		
	        deleted.setNext(null);
		}
		size--;
		return deleted.getData();
	}
	
	public e top() { 
		if (isEmpty())
			return null;
		return head.getNext().getData();
	}
	
	public void print() {
		Node<e> curr = head.getNext();
		e[] arr = (e[]) new Object[size];
		
		for (int k = 0; k < size; k++) {
			arr[k] = curr.getData();
			curr = curr.getNext();
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public e next() {
		if (curr != null) {
			e temp = curr.getData();
		    curr = curr.getNext();
		    return temp;
		} else {
			return null;
		}
		
	}
}
