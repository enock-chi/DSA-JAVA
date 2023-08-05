package dsa716;

public interface PositionalList<e> {
	int size();
	
	boolean isEmpty();
	
	Position<e> first();
	
	Position<e> last();
	
	Position<e> addFirst(e data);
	
	Position<e> addLast(e data);
	
	e before(int i) throws IllegalArgumentException;
	
	e after(int i) throws IllegalArgumentException;
	
	Position<e> addBefore(int i, e data) throws IllegalArgumentException;
	
	Position<e> addAfter(int i, e data) throws IllegalArgumentException;
	
	e set(int i, e data) throws IllegalArgumentException;
	
	e remove(int i) throws IllegalArgumentException;
}
