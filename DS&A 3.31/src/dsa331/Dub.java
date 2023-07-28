package dsa331;
import java.util.*;

public class Dub<d> {
//======================================
	private static class Node<d>{
		private d data;
		private Node<d> prev;
		private Node<d> next;
		
		public Node(d el, Node<d> p, Node<d> n){
			data = el;
			prev = p;
			next = n;
		}
		
		public d getData() { return data;}
		
		public void setNext(Node<d> el) { next = el;}
		
		public void setPrev(Node<d> el) { prev = el;}
		
		public Node<d> getNext(){ return next;}
		
		public Node<d> getPrev(){ return prev;}
	}
//======================================
	
	private Node<d> pole = new Node<>(null,null,null);
	private int size = 0;
	
	public Dub() {	}
	
	public boolean isEmpty() { return ( size == 0) ? true : false;}
	
	public void addFirst(d el) {
		if (isEmpty()) {
			add(el, pole, pole);
		} else {
			add(el,pole, pole.getNext());
		}
	}
	
	public void addLast(d el) {
		if (isEmpty()) {
			add(el,pole,pole);
		} else {
			add(el,pole.getPrev(),pole);
		}
	}
	
	public void add(d el, Node<d> p, Node<d> n) {
		Node<d> newest = new Node<>(el,p,n);
		n.setPrev(newest);
		p.setNext(newest);
		size++;
	}
	
	public void removeFirst() {
		d el = remove(pole.getNext());
	}
	
	public void removeLast() {
		d el = remove(pole.getPrev());
	}
		
	
	public d remove( Node<d> c) {
		Node<d> data = c;
		if ( c == pole.getNext()) {
			pole.setNext(pole.getNext().getNext());
			pole.getNext().setPrev(pole);
		} else {
			pole.setPrev(pole.getPrev().getPrev());
			pole.getPrev().setNext(pole);;
		}
		size -= 1;
		
		
		return data.getData();
	}
	
	public void output() {
		Node<d> curr = pole.getNext();
		int[] arr = new int[size];
		for (int k = 0; k < size; k++) {
			arr[k] = (curr.getData() != null) ? (int)curr.getData() : 0;
			curr = curr.getNext();
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("==========================================");
		System.out.println("");
		System.out.println(size);
	}

}
