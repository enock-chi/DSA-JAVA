package dsa815;
import java.util.*;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
//=====================================Nested Node Class=====================================
	private static class Node<E> implements Position<E>{
		private E data;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		
		public Node(E data, Node<E> parent, Node<E> left, Node<E> right) {
			this.data = data;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		
		public E getData() { return data;}
		public void setData(E data) { this.data = data;}
		
		public Node<E> getParent() { return parent;}
		public void setParent(Node<E> parent) { this.parent = parent;}
		
		public Node<E> getLeft() { return left;}
		public void setLeft(Node<E> left) { this.left = left;}
		
		public Node<E> getRight() { return right;}
		public void setRight(Node<E> right) { this.right = right;}
	}
//===================================End Nested Node Class===================================
	protected Node<E> root = null;
	private int size = 0;
	
	protected Node<E> createNode(E data, Node<E> parent, Node<E> left, Node<E> right){
		return new Node(data,parent,left,right);
	}
	
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("P is not valid");
		Node<E> n = (Node<E>) p;
		if (n.getParent() == n) throw new IllegalArgumentException("P is no longer in Tree");
		return n;
	}
	
	public LinkedBinaryTree() {}
	
	public int size() { return size;}
	
	public Position<E> root() { return root;}
	
	public Position<E> parent(Position<E> p) throws IllegalArgumentException{
		Node<E> n = validate(p);
		return n.getParent();
	}
	
	public Position<E> left(Position<E> p) throws IllegalArgumentException{
		Node<E> n = validate(p);
		return n.getLeft();
	}
	
	public Position<E> right(Position<E> p) throws IllegalArgumentException{
		Node<E> n = validate(p);
		return n.getRight();
	}
	
	public Position<E> addRoot(E data) {
		if (!isEmpty()) throw new IllegalArgumentException("Tree has a root");
		root = createNode(data,null,null,null);
		size++;
		return root;
	}
	
	public Position<E> addLeft(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> n = validate(p);
		if (n.getLeft() != null) throw new IllegalArgumentException("Left already exists");
		Node<E> child = createNode(data,n,null,null);
		n.setLeft(child);
		size++;
		return child;
	}
	
	public Position<E> addRight(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> n = validate(p);
		if (n.getRight() != null) throw new IllegalArgumentException("Right already exists");
		Node<E> child = createNode(data,n,null,null);
		n.setRight(child);
		size++;
		return child;
	}
	
	public E set(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> n = validate(p);
		E bin = n.getData();
		n.setData(data);
		return bin;
	}
	
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (isInternal(p)) throw new IllegalArgumentException("P must be a leaf");
		size += t1.size() + t2.size();
		if (!t1.isEmpty()) {
			t1.root.setParent(parent);
			parent.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if (!t2.isEmpty()) {
			t2.root.setParent(parent);
			parent.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}
	
	public E remove(Position<E> p) throws IllegalArgumentException{
		Node<E> n = validate(p);
		E bin = n.getData();
		if (numChildren(p) == 2) throw new IllegalArgumentException("Position has two children");
		Node<E> child = (n.getLeft() != null) ? n.getLeft() : n.getRight();
		if (child != null) {
			child.setParent(n.getParent());
		}
		if ( n == root) {
			root = child;
		} else {
			Node<E> parent = n.getParent();
			if (n == parent.getLeft()) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}
		size--;
		n.setData(null);
		n.setLeft(null);
		n.setRight(null);
		n.setParent(n);
		return bin;
	}
	
	public int level(Position<E> p) throws IllegalArgumentException{
		validate(p);
		if (isRoot(p))
			return 0 ;
		else 
			return 1 + level(parent(p));
	}
	
	public void print(Position<E> p) {

		System.out.print("(" + p.getData());
		for (Position<E> c: children(p)) {
			print(c);
			System.out.print(")");
		}
		
	} 
//============================================Nested ElementIterator============================================
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = positions().iterator();
		public boolean hasNext() {return posIterator.hasNext();}
		public E next() { return posIterator.next().getData();}
		public void remove() { posIterator.remove();}
	}
//==========================================End Nested ElementIterator==========================================
	public Iterator<E> iterator() { return new ElementIterator();}
	
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		snapshot.add(p);
		for (Position<E> c : children(p)) {
			preorderSubtree(c,snapshot);
		}
	}
	
	public Iterable<Position<E>> preorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			preorderSubtree(root(),snapshot);
		}
		return snapshot;
	}
	
	public Iterable<Position<E>> positions() { return preorder();}
	
	
}
