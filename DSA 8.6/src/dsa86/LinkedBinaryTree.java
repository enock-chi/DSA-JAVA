package dsa86;

import java.util.*;


public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	protected static class Node<E> implements Position<E>{
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
		public void setData(E data) { this .data = data;}
		
		public Node<E> getParent() { return parent;}
		public void setParent(Node<E> parent) { this.parent = parent;}
		
		public Node<E> getLeft() { return left;}
		public void setLeft(Node<E> left) { this.left = left;}
		
		public Node<E> getRight() { return right;}
		public void setRight(Node<E> right) { this.right = right;}
	}
	
	protected Node<E> createNode(E data, Node<E> parent, Node<E> left, Node<E> right){
		return new Node(data,parent,left,right);
	}
	
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Not a valid position");
		Node<E> n = (Node<E>) p;
		if ( n == n.getParent()) throw new IllegalArgumentException("Position not in tree");
		return n;
	}
	
	protected Node<E> root = null;
	private int size = 0;
	
	public LinkedBinaryTree() {}
	
	public int size() { return size;}
	
	public Position<E> root() { return root;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public Position<E> parent(Position<E> p) {
		Node<E> n = validate(p);
		return n.getParent();
	}
	
	public Position<E> left(Position<E> p) {
		Node<E> n = validate(p);
		return n.getLeft();
	}
	
	public Position<E> right(Position<E> p) {
		Node<E> n = validate(p);
		return n.getRight();
	}
	
	public Position<E> addRoot(E data) throws IllegalStateException {
		if (!(isEmpty())) throw new IllegalStateException("Tree is not Empty");
		root = createNode(data,null,null,null);
		size++;
		return root;
	}
	
	public Position<E> addLeft(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if (parent.getLeft() != null) throw new IllegalArgumentException("Parent already has left child");
		Node<E> child = createNode(data,parent,null,null);
		parent.setLeft(child);
		size++;
		return child;
	}
	
	public Position<E> addRight(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if (parent.getRight() != null) throw new IllegalArgumentException("Parent already has right child");
		Node<E> child = createNode(data,parent,null,null);
		parent.setRight(child);
		size++;
		return child;
	}
	
	public E set(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> n = validate(p);
		E removedData = n.getData();
		n.setData(data);
		return removedData;
	}
	
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException{
		Node<E> n = validate(p);
		if (isInternal(p)) throw new IllegalArgumentException("Parent must be a leaf");
		size = t1.size() + t2.size();
		if (!t1.isEmpty()) {
			t1.root.setParent(n);
			n.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if (!t2.isEmpty()) {
			t2.root.setParent(n);
			n.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}
	
	public E remove(Position<E> p) throws IllegalArgumentException{
		Node<E> n = validate(p);
		if (numChildren(p) == 2) throw new IllegalArgumentException("Parent has 2 children");
		Node<E> child = (n.getLeft() != null ? n.getLeft() : n.getRight());
		if (child != null) {
			child.setParent(n.getParent());
		}
		if ( n == root ) root = child;
		else {
			Node<E> parent = n.getParent();
			if (n == parent.getLeft()) parent.setLeft(child);
			else parent.setRight(child);
		}
		size--;
		E bin = n.getData();
		n.setData(null);
		n.setParent(n);
		n.setLeft(null);
		n.setRight(null);
		return bin;
	}
	
	public void print() {
		printHelper(root());
	}
	
	public void printHelper(Position<E> p) {
		System.out.print("(");
		System.out.print(p.getData());
		if (numChildren(p) == 0) return;
		else {
			for (Position<E> c : children(p)) {
				printHelper(c);
				System.out.print(")");
			}
		}
	}
	
	public void printProper() {
		printProperHelper(new ArrayList<>(Arrays.asList(root())));
	}
	
	private void printProperHelper(ArrayList<Position<E>> list) {
		ArrayList<Position<E>> tempList = new ArrayList<>();
		if (list.isEmpty()) {
			System.out.print(")");
			return ;
		}
		for ( Position<E> c : list) {
			System.out.print("(");
			if (c == null) {
				System.out.print("null");
				
			} else {
				System.out.print(c.getData());
				
				if (numChildren(c) > 0) {
					tempList.add(((Node<E>)c).getLeft());
			        tempList.add(((Node<E>)c).getRight());
				}
				
			}
		
			printProperHelper(tempList);
			tempList.clear();
		}
		System.out.print(")");
		
	}
	
//=====================================Nested ElementIterator Class=====================================
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = positions().iterator();
		public boolean hasNext() { return posIterator.hasNext();}
		public E next() { return posIterator.next().getData();}
		public void remove() { posIterator.remove();}
	}
//=================================End Nested ElementIterator Class=====================================
	
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
