package dsa639;
import java.util.*;

public class LinkedList<e> {
//==============================================
	public static class Node<e>{
		private e data;
		private Node<e> next;
		
		public Node(e data, Node<e> next) {
			this.data = data;
			this.next = next;
		}
		
		public e getData() { return data;}
		
		public Node<e> getNext(){ return next;}
		
		public void setNext(Node<e> data) { this.next = data;}
	}
//==============================================
	private Node<e> head = null;
	private Node<e> tail = null;
	private int max = 0;
	private int size = 0;
	
	public LinkedList() {}
	
	public LinkedList(int cap) { max = cap;}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size==0);}
	
	public void push(e data) { 
		Node<e> newest = new Node<>(data,null);
		if(size == max ) pop();
		if(isEmpty()) {
			tail = newest;
		} else {
			newest.setNext(head);
		}
		head = newest;
		size++;
	}
	
	public e pop() {
		if(isEmpty()) return null;
		Node<e> node = head;
		head = node.getNext();
		node.setNext(null);
		if (size==0) tail = null;
		size--;
		return node.getData();
	}
	
	public e top() { return head.getData();}
	
	public void print() {
		Node<e> curr = head;
		e[] arr = (e[]) new Object[size];
		for ( int k = 0 ; k < size ; k++) {
			arr[k] = curr.getData();
			curr = curr.getNext();
		}
		System.out.println(Arrays.toString(arr));
	}

}
