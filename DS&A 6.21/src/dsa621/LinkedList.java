package dsa621;
import java.util.*;

public class LinkedList<e> implements Cloneable{
//================================================
	private static class Node<e>{
		private e data;
		private Node<e> next;
		
		public Node(e data, Node<e> next) {
			this.data = data;
			this.next = next;
		}
		
		public void setNext(Node<e> next) { this.next = next;}
		
		public Node<e> getNext(){ return next;}
		
		public e getData() { return  data;}
	}
//================================================
	private Node<e> tail = new Node(null,null);
	private boolean seal = true;
	Node<e> first = null;
	Node<e> next = null ;
	private int size = 0;
	
	public void add(e data) {
		Node<e> newest = new Node<>(data,null);
		if (isEmpty()) {
			tail.setNext(newest);
			first = newest;
		} else {
			newest.setNext(tail.getNext());
			tail.setNext(newest);
			first.setNext(newest);
		}
		size++;
	}
	
	public void rotate() {
		if (!isEmpty()) {
	        Node<e> curr = tail.getNext();
	        tail.setNext(curr.getNext());
	        if (tail.getNext() != null) {
	            first.setNext(curr);
	            first = curr;
	            first.setNext(tail.getNext());
	        } else {
	            first = null;  // Update first reference to null when list becomes empty
	        }
	    }	}
	
	public e next() {
		if (seal) {
			next = tail.getNext();
			seal = false;
		} else if (next.getNext() != null){
			next = next.getNext();
		} else {
			return null;
		}
		
		return next.getData();
	}
	
	
	
	public e pop() {
		if (tail.getNext() == null) {
	        return null; // Return null when the list is empty
	    }
	    Node<e> last = tail.getNext();
	    tail.setNext(last.getNext());
	    if (first == last) {
	        first = null; // Update first reference to null when the list becomes empty
	    }
	    size--;
		return last.getData();
	}
	
	public boolean isEmpty() { return (size == 0);}
	
	public e first() { 
		if(isEmpty()) {
			return null;
		}
		return tail.getNext().getData();
	}
	
	public int size() { return size;}
	
	public void print() {
		Node<e> curr = tail.getNext();
		Object[] arr = new Object[size];
		for (int k = 0; k < size; k++) {
			if (curr == null) {
				continue;
			}
			arr[k] = curr.getData();
			curr = curr.getNext();
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public LinkedList<e> clone() throws CloneNotSupportedException{
		LinkedList<e> other = (LinkedList<e>) super.clone();
		other.tail = new Node<>( null,null);
		other.size = 0;
		
		if (size > 0) {
			Node<e> walk = this.tail.getNext();
		    Node<e> otherTail = other.tail;
		    for (int k = 0; k < this.size; k++) {
		    	if (walk == null) {
		    		return other;
		    	}
			   Node<e> newest = new Node<>(walk.getData(),null);
			   otherTail.setNext(newest);
			   otherTail = newest;
			   walk = walk.getNext();
			   other.size++;
		    }
		    if (walk == tail) {
			   otherTail.setNext(other.tail);
			   other.size++;
		    }
		}
		
		return other;
	}

}
