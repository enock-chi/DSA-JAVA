package dsa815;
import java.util.*;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
		Position<E> parent = parent(p);
		if (parent == null) return null;
		if (p == left(parent)) {
			return right(parent);
		} else {
			return left(parent);
		}
	}
	
	public int numChildren(Position<E> p) throws IllegalArgumentException{
		int count = 0;
		if ( p == left(p)) {
			count++;
		}
		if ( p == right(p)) {
			count++;
		}
		return count;
	}
	
	public Iterable<Position<E>> children(Position<E> p){
		List<Position<E>> snapshot = new ArrayList<>(2);
		if ( left(p) != null) {
			snapshot.add(right(p));
		}
		if ( right(p) != null) {
			snapshot.add(left(p));
		}
		return snapshot;
	}
}
