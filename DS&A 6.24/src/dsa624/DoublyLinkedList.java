package dsa624;
import java.util.*;

public class DoublyLinkedList<e> {
//=============================================================
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
//===============================================================
	private Node<e> tail = new Node<>(null,null,null);
	private Node<e> head = new Node<>(null,tail,null);
	private int size = 0;
	
	public DoublyLinkedList() {}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public e first() { return head.getNext().getData();}
	
	public void queue( e data) {
		Node<e> newest = new Node<>(data,head.getNext(),null);
		if (isEmpty()) {
			newest.setPrev(head);
			head.setNext(newest);
			tail.setPrev(newest);
		} else {
			head.getNext().setPrev(newest);
			head.setNext(newest);
			newest.setPrev(head);
		}
		size++;
	}
	
	public e dequeue() {
		Node<e> node = tail.getPrev();
		if (isEmpty()) {
			return null;
		} else {
			tail.setPrev(node.getPrev());
		    node.getPrev().setNext(tail);
		    node.setNext(null);
		    node.setPrev(null);
		}
		
		size--;
		return node.getData();
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
	
	public boolean scan(LinkedStack<e> stack, e element) {
		for (int j = 0; j < stack.size(); j++) {
			if (stack.next() == element) {
				return true;
			}
		}
		return false;
	}

}
