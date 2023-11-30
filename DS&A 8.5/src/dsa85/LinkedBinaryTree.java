package dsa85;

import java.util.*;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
//================================Nested Node Class==============================
	private static class Node<E> implements Position<E>{
		private E data;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		//Constructor
		public Node(E data, Node<E> parent, Node<E> left, Node<E> right) {
			this.data = data;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		//getter methods
		public E getData() { return data;}
		public Node<E> getParent(){ return parent;}
		public Node<E> getLeft(){ return left;}
		public Node<E> getRight(){ return right;}
		//setter methods
		public void setData( E Data ) { this.data = data;}
		public void setParent( Node<E> parent ) { this.parent = parent;}
		public void setLeft(Node<E> left ) { this.left = left;}
		public void setRight( Node<E> right ) { this.right = right;}
		
	}
//==============================End Nested Node Class============================
	
	protected Node<E> createNode(E data, Node<E> parent, Node<E> left, Node<E> right) {
		return new Node<>(data,parent,left,right);
	}
	
	
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if (!( p instanceof Node)) throw new IllegalArgumentException("Not a valid position");
		Node<E> node = (Node<E>) p;
		if (node.getParent() == node) throw new IllegalArgumentException("Position is no longer in tree");
		return node;
	}
	
	protected Node<E> root = null;
	private int size = 0;
	
	public LinkedBinaryTree() {}
	
	public int size() { return size;}
	
	public Position<E> root() { return root;}
	
	public Position<E> parent(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getParent();
	}
	
	public Position<E> left(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getLeft();
	}
	
	public Position<E> right(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getRight();
	}
	
	public Position<E> addRoot(E data) throws IllegalStateException{
		if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
		root = createNode(data,null,null,null);
		size++;
		return root;
	}
	
	
	public Position<E> addLeft(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if ( node.getLeft() != null) throw new IllegalArgumentException("Left has a value");
		Node<E> child = createNode(data,node,null,null);
		node.setLeft(child);
		size++;
		return child;
	}
	
	public Position<E> addRight(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if ( node.getRight() != null ) throw new IllegalArgumentException("Right is not empty");
		Node<E> child = createNode(data,node,null,null);
		node.setRight(child);
		size++;
		return child;
	}
	
	public E set(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> node = validate(p);
		E bin = node.getData();
		node.setData(data);
		return bin;
	}
	
	public E remove(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if (numChildren(p) == 2) throw new IllegalStateException("Position has two children");
		Node<E> child = ((node.getLeft() != null) ? node.getLeft() : node.getRight());
		if ( child != null) child.setParent(node.getParent());
		if (node == root) root = child;
		else {
			Node<E> parent = node.getParent();
			if (node == parent.getLeft()) parent.setLeft(child);
			else parent.setRight(child);
		}
		size--;
		E bin = node.getData();
		node.setData(null);
		node.setParent(node);
		node.setLeft(null);
		node.setRight(null);
		return bin;
	}
	
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if (isInternal(p)) throw new IllegalArgumentException("Position must be a leaf");
		size += t1.size() + t1.size();
		if (!t1.isEmpty()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if (!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}
	
//=======================================Nested ElementIterator=======================================
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = positions().iterator();
		public boolean hasNext() { return posIterator.hasNext();}
		public E next() { return posIterator.next().getData();}
		public void remove() { posIterator.remove();}
	}
//=====================================End Nested ElementIterator=====================================
	
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot ) {
		snapshot.add(p);
		for (Position<E> c: children(p)) {
			preorderSubtree(c,snapshot);
		}
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ElementIterator();
	}


	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		return preorder();
	}
	
	public Iterable<Position<E>> preorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			preorderSubtree(root(),snapshot);
		}
		return snapshot;
	}
	
	public int leaves() {
		return leafHelper(root(), 0);
	}
	
	private int leafHelper(Position<E> p, Integer count) {
		if (numChildren(p) == 0) return ++count;
		else {
			for (Position<E> c : children(p)) {
				count = leafHelper(c,count);
			}
		}
		return count;
	}
	
	public void print(Position<E> p, ArrayList<E> toPrint) throws IllegalStateException {
		if (isEmpty()) throw new IllegalStateException("Tree is empty!");
		System.out.print("(");
		System.out.print(p.getData());
	    for(Position<E> c: children(p)) {
		    print(c,toPrint);
		}
	    System.out.print(")");
	    if (numChildren(p) == 0) return ;
		
	}
	
	


}
