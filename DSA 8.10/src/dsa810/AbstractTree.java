package dsa810;

public abstract class AbstractTree<E> implements Tree<E>{
	public boolean isInteral(Position<E> p) { return (numChildren(p) > 0);}
	public boolean isExternal(Position<E> p) { return (numChildren(p) == 0);}
	public boolean isRoot(Position<E> p) { return (root() == p);}
	public boolean isEmpty(Position<E> p) { return (size() == 0);}
}
