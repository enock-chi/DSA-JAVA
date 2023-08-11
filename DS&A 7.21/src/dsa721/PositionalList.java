package dsa721;

import dsa721.MTF.Item;

public interface PositionalList<e> {
	int size();
	
	boolean isEmpty();
	
	Position<e> first();
	
	Position<e> last();
	 
	Position<e> addFirst(e data);
	
	Position<e> addLast( e data);
	
	Position<e> after(int i) throws IllegalArgumentException;
	
	Position<e> before(int i) throws IllegalArgumentException;
	
	Position<e> addBefore(int i, e data) throws IllegalArgumentException;
	
	Position<e> addAfter(int i, e dtata) throws IllegalArgumentException;
	
	e set(int i, e data) throws IllegalArgumentException;
	
	e remove(int i) throws IllegalArgumentException;

	int index(Position<e> p);

}
