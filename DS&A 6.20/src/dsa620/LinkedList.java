package dsa620;
import java.util.*;

public class LinkedList<e> {
//================================================
	private static class Node<e> {
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
//==================================================
	private Node<e> tail = new Node<>(null,null);
	private Node<e> head = new Node<>(null,tail);
	private int size = 0;
	
	public LinkedList() {}
	
	public int getSize() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public void add(e data) {
		Node<e> newest = new Node<>(data,null);
		if (isEmpty()) {
			newest.setNext(tail);
		} else {
			newest.setNext(head.getNext());
		}
		head.setNext(newest);
		size++;
	}
	
	public e remove() {
		Node<e> last = head.getNext();
		head.setNext(last.getNext());
		size--;
		return last.getData();
	}
	
	public e first() {
		return head.getNext().getData();
	}
	
	
	public void print() {
		Node<e> curr = head.getNext();
		Object[] arr = new Object[size];
		for ( int k = 0; k < size; k++) {
			if (curr == null) {
	            arr[k] = -1;
	        } else {
			arr[k] = curr.getData();
	        }
			curr = curr.getNext();
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
