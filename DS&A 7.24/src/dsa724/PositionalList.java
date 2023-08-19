package dsa724;
import java.lang.Iterable;

public interface PositionalList<e> extends Iterable<e>{
	int size();
	
	boolean isEmpty();
	
	Position<e> first();
	
	Position<e> last();
	
	Position<e> after(Position<e> p) throws IllegalArgumentException;
	
	Position<e> before(Position<e> p) throws IllegalArgumentException;
	
	Position<e> addFirst( e data );
	
	Position<e> addLast( e data );
	
	Position<e> addAfter(Position<e> p, e data) throws IllegalArgumentException;
	
	Position<e> addBefore(Position<e> p, e data) throws IllegalArgumentException;
	
	e set(Position<e> p, e data) throws IllegalArgumentException;
	
	e remove(Position<e> p) throws IllegalArgumentException;
	

}
