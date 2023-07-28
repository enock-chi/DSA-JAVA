package dsa311;
import java.util.*;

public class Dlist<t> {
//=========================================
	private static class Node<t>{
		private t data;
		private Node<t> prev;
		private Node<t> next;
		
		public Node(t el, Node<t> p, Node<t> n) {
			data = el;
			prev = p;
			next = n;
		}
		
		public t getData() { return data;}
		
		public Node<t> getNext(){ return next;}
		
		public Node<t> getPrev(){ return prev;}
		
		public void setNext(Node<t> n) { next = n;}
		
		public void setPrev(Node<t> p) { prev = p;}
	}
	
//=========================================
	
	private Node<t> head = new Node<>(null,null,null);
	private Node<t> tail = new Node<>(null,head,null);
	
	public Dlist() {
		head.setNext(tail);
	}
	
	public int size() {
		int count = 0;
		Node<t> curr = head.getNext();
		while (curr != tail) {
			count++;
			curr = curr.getNext();
		}
 		return count;
	}
	
	public void add(t el, Node<t> p, Node<t> n) {
		Node<t> newest = new Node<>(el,p,n);
		p.setNext(newest);
		n.setPrev(newest);
	}
	
	public void addFirst(t el) {
		add(el,head, head.getNext());
	}
	
	public void addLast(t el) {
		add(el,tail.getPrev(),tail);
	}
	
	public t first() { return head.getNext().getData();}
	
	public t last() { return tail.getPrev().getData();}
	
	public void output() {
		Node<t> curr = head.getNext();
		int[] arr = new int[size()];
		for ( int k = 0; k < size(); k++) {
			arr[k] = (int)curr.getData();
			curr = curr.getNext();
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("============================================");
		System.out.println("");
		
	}
	
	public t removeFirst() {
		return remove(head.getNext());
	}
	
	public t removeLast() {
		return remove(tail.getPrev());
	}
	
	public t remove(Node<t> el) {
		el.getPrev().setNext(el.getNext());
		el.getNext().setPrev(el.getPrev());
		
		el.setNext(null);
		el.setPrev(null);
		return el.getData();
	}
	
	
	
	
	}
