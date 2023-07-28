package dsa625;

import java.util.Arrays;

public class LinkedList<e> {
//===========================================
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
//===========================================
    private Node<e> tail = null;
    private Node<e> head = null;
    private int size = 0;
    
    public LinkedList() {}
    
    public int size() { return size;}
    
    public boolean isEmpty() { return (size == 0);}
    
    public e top() { return head.getNext().getData();}
    
    public void push(e data) {
    	Node<e> newest = new Node<>(data, null);
    	if (isEmpty()) {
    		head = newest;
    	} else {
    		tail.setNext(newest);
    	}
    	tail = newest;
    	size++;
    }
    
    public e pop() {
    	Node<e> node = head;
    	if (isEmpty()) {
    		return null;
    	} else {
    		head = node.getNext();
    		node.setNext(null);
    	}
    	size--;
    	return node.getData();
    	
    }
    
    public void print() {
    	Node<e> curr = head;
    	e[] arr = (e[]) new Object[size];
    	for ( int j = 0 ; j < size ; j++) {
    		arr[j] = curr.getData();
    		curr = curr.getNext();
    	}
    	
    	System.out.println(Arrays.toString(arr));
    }
}
