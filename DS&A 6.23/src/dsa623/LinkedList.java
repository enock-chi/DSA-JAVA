package dsa623;
import java.util.*;

public class LinkedList<e> implements Stack<e>{
//==============================================================
	private static class Node<e>{
		private e data;
		private Node<e> next;
		
		public Node(e data, Node<e> next) {
			this.data = data;
			this.next = next;
		}
		
		public void setNext(Node<e> next) { this.next = next;}
		
		public e getData( ) { return data;}
		
		public Node<e> getNext(){ return next;}
	}
//==============================================================
	private int size = 0;
	private Node<e> tail = new Node<>(null,null);
	private Node<e> head = new Node<>(null,tail);
	
	public LinkedList() {}
	
	@Override
	public int size() { return size;}
	
	@Override
	public boolean isEmpty() { return (size == 0);}
	
	@Override
	public void push(e data) {
		Node<e> newest = new Node<>(data,null);
		if (isEmpty()) {
			newest.setNext(tail);
			head.setNext(newest);
			size++;
		} else {
			newest.setNext(head.getNext());
			head.setNext(newest);
			size++;
		}
		
	}
	
	@Override
	public e pop() {
		Node<e> node = head.getNext();
		if (isEmpty()) return null;
		head.setNext(node.getNext());
		node.setNext(null);
		size--;
		return node.getData();
	}
	
	@Override
	public e top() {
		if (isEmpty()) return null;
		return head.getNext().getData();
	}
	
	public void print() {
		e[] arr = (e[]) new Object[size];
		Node<e> curr = head.getNext();
		for (int k = 0; k < size;  k++) {
			arr[k] = curr.getData();
			curr = curr.getNext();
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
