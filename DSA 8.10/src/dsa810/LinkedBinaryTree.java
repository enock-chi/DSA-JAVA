package dsa810;
import java.util.*;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E>{
//====================================Nested Node Class====================================
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
		public void setData(E ddata) { this.data = data;}
		
		public Node<E> getParent() { return parent;}
		public void setParent(Node<E> parent) { this.parent = parent;}
		
		public Node<E> getLeft() { return left;}
		public void setLeft(Node<E> left) { this.left = left;}
		
		public Node<E> getRight() { return right;}
		public void setRight(Node<E> right) { this.right = right;}
	}
//==================================End Nested Node Class==================================
	private Node<E> root = null;
	private int size = 0;
	
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if (!(p instanceof Node)) throw new IllegalArgumentException("Position not valid");
		Node<E> n = (Node<E>)p;
		if (n.getParent() == p) throw new IllegalArgumentException("Position not valid in list");
		return n;
	}
	
	protected Node<E> createNode(E data, Node<E> parent, Node<E> left, Node<E> right){
		return new Node<>(data,parent,left,right);
	}
	
	public LinkedBinaryTree() { }
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0);}
	
	public Position<E> root() { return root;}
	
	public Position<E> parent(Position<E> p) throws IllegalArgumentException{
		return validate(p).getParent();
	}
	
	public Position<E> left(Position<E> p) throws IllegalArgumentException{
		return validate(p).getLeft();
	}
	
	public Position<E> right(Position<E> p) throws IllegalArgumentException{
		return validate(p).getRight();
	}
	
	public Position<E> addRoot(E data) throws IllegalStateException{
		if (!isEmpty()) throw new IllegalStateException("Root already exists");
		root = createNode(data,null,null,null);
		size++;
		return root;
	}
	
	public Position<E> addLeft(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> n = validate(p);
		if (n.getLeft() != null) throw new IllegalArgumentException("Left already exists for Position");
		Node<E> child = createNode(data,n,null,null);
		n.setLeft(child);
		size++;
		return child;
	}
	
	public Position<E> addRight(Position<E> p, E data) throws IllegalArgumentException{
		Node<E> n = validate(p);
		if (n.getRight() != null) throw new IllegalArgumentException("Right already exists for Position");
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
	
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException{
		Node<E> n = validate(p);
		if (isInternal(p)) throw new IllegalArgumentException("Position must be a leaf");
		size += t1.size() + t2.size();
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
		if (numChildren(p) == 2) throw new IllegalArgumentException("Position has two children");
		Node<E> child = (n.getLeft() != null) ? n.getLeft() : n.getRight();
		if (child != null) {
		    child.setParent(n.getParent());			
		}
		if (n == root) root = child;
		else {
			Node<E> parent = n.getParent();
			if (n == left(parent)) parent.setLeft(child);
			else parent.setRight(child);
		}
		size--;
		E bin = n.getData();
		n.setData(null);
		n.setLeft(null);
		n.setRight(null);
		n.setParent(n);
		return bin;
	}
	
	public int answer(Position<E> p) throws IllegalArgumentException{
		Node<E> n = validate(p);
		if (isExternal(p)) {
			Integer num = Integer.valueOf((String)n.getData());
			return num;
			} else {
				String operator = (String) n.getData();
				int result = 0;
				for (Position<E> c : children(p)) {
					switch(operator) {
					case "*":
						if (result == 0) result = 1;
						result *= answer(c);
						break;
					case "/":
						if (result == 0) result = answer(c);
						else result /= answer(c);
						break;
					case "+":
						result = answer(c) + result;
						break;
					case "-":
						result = answer(c) - result;
						break;
					}
				}
			return result;
			}
		}
	
	
	
//=====================================Nested ElementIterator Class=====================================
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = positions().iterator();
		public boolean hasNext() { return posIterator.hasNext();}
		public E next() { return posIterator.next().getData();}
		public void remove() { posIterator.remove();}
		
	}
//===================================End Nested ElementIterator Class===================================
	public Iterator<E> iterator() { return new ElementIterator();}
	
	public Iterable<Position<E>> positions() { return preorder();}
	
	
	private void preorderSubtree(Position<E> p, List<Position<E>> list) {
		list.add(p);
		for (Position<E> c: list) {
			preorderSubtree(c,list);
		}
	}
	
	public Iterable<Position<E>> preorder(){
		List<Position<E>> list = new ArrayList<>();
		if (!isEmpty()) {
			preorderSubtree(root(),list);
		}
		return list;
	}
	
}
