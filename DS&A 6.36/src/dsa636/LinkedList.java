package dsa636;
import java.util.*;

public class LinkedList<e> {
//==============================================
	private static class Node<e>{
		private e data;
		private Node<e> next;
		
		public Node(e data, Node<e> next) {
			this.data = data;
			this.next = next;
		}
		
		public e getData() { return data;}
		
		public void setNext(Node<e> next) { this.next = next;}
		
		public Node<e> getNext(){ return next;}
		
	}
//===============================================
	private Node<e> head = null;
	private Node<e> tail = null;
	private int size = 0;
	
	public LinkedList() {}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public void push(e data) {
		Node<e> newest = new Node<e>(data,null);
		if(isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
		
	}
	
	public e pop() {
		Node<e> deleted = head;
		if (isEmpty()) return null;
		head = deleted.getNext();
		deleted.setNext(null);
		size--;
		return deleted.getData();
	}
	
	public e top() {return head.getData();}
	
	public void print() {
		Node<e> curr = head;
		e[] arr = (e[]) new Object[size];
		for (int k = 0; k < size; k++) {
			arr[k] = curr.getData();
			curr = curr.getNext();
		}
		System.out.println(Arrays.toString(arr));
	}
	
}
