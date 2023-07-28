package dsa623;
import java.util.*;

public class CircleList<e> implements Queue<e>{
//===========================================
	private static class Node<e>{
		private e data;
		private Node<e> next;
		private Node<e> prev;
		
		public Node(e data, Node<e> next, Node<e> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		public e getData() { return data;}
		public Node<e> getNext(){ return next;}
		public Node<e> getPrev(){ return prev;}
		public void setNext(Node<e> next) { this.next = next;}
		public void setPrev(Node<e> prev) { this.prev = prev;}
	}
//===========================================
	private int size = 0;
	private Node<e> tail = new Node<>(null,null,null);
	private Node<e> head = new Node<>(null,tail,null);
	
	public CircleList() {};
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public void queue(e data) {
		Node<e> newest = new Node<>(data,null,null);
		if (isEmpty()) {
			newest.setNext(tail);
			newest.setPrev(head);
			tail.setPrev(newest);
			head.setNext(newest);
			size++;
		} else {
			newest.setNext(head.getNext());
			newest.setPrev(head);
			head.getNext().setPrev(newest);
			head.setNext(newest);
			tail.getPrev().setNext(head.getNext());
			size++;
		}
	}
	
	public void rotate() {
		tail.setNext(head.getNext());
		head.setNext(head.getNext().getNext());
	}
	
	public e dequeue() {
		Node<e> node = tail.getPrev();
		if (isEmpty()) return null;
		tail.setPrev(node.getPrev());
		node.getPrev().setNext(tail);
		node.setNext(null);
		node.setPrev(null);
		size--;
		return node.getData();
	}
	
	public e first() { return head.getNext().getData();}
	
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
